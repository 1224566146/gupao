package com.fan.gupao.spring.framework.context;

import com.fan.gupao.spring.framework.annotation.GPAutowired;
import com.fan.gupao.spring.framework.annotation.GPController;
import com.fan.gupao.spring.framework.annotation.GPService;
import com.fan.gupao.spring.framework.aop.GPDefaultAopProxyFactory;
import com.fan.gupao.spring.framework.aop.config.GPAopConfig;
import com.fan.gupao.spring.framework.aop.support.GPAdvisedSupport;
import com.fan.gupao.spring.framework.beans.GPBeanWrapper;
import com.fan.gupao.spring.framework.beans.config.GPBeanDefinition;
import com.fan.gupao.spring.framework.beans.support.GPBeanDefinitionReader;
import com.fan.gupao.spring.framework.core.GPBeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 职责：完成Bean的创建和DI
 * @Author: 樊高风
 * @Date: 15:40 2020/4/27
 */
public class GPApplicationContext implements GPBeanFactory {

    private GPBeanDefinitionReader reader;

    private Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private Map<String, GPBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();

    private Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    private GPDefaultAopProxyFactory proxyFactory = new GPDefaultAopProxyFactory();


    public GPApplicationContext(String... contextConfigLocation) {

        //1、加载配置文件
        reader = new GPBeanDefinitionReader(contextConfigLocation);

        try {
            //2、解析配置文件，封装成BeanDefinition
            List<GPBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();

            //3、把BeanDefinition缓存起来
            doRegistBeanDefinition(beanDefinitions);

            doAutowrited();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doAutowrited() {
        //调用getBean()
        //这一步，所有的Bean并没有真正的实例化，还只是配置阶段
        for (Map.Entry<String, GPBeanDefinition> beanDefinitionEntry : this.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            getBean(beanName);
        }
    }


    private void doRegistBeanDefinition(List<GPBeanDefinition> beanDefinitions) throws Exception {

        for (GPBeanDefinition beanDefinition : beanDefinitions) {

            if (this.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + "is exists");
            }

            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(), beanDefinition);

        }

    }

    @Override
    public Object getBean(Class beanClass) {
        return getBean(beanClass.getName());
    }

    //Bean的实例化，DI是从这个方法开始的
    @Override
    public Object getBean(String beanName) {

        // 1、先拿到BeanDefinition配置信息
        GPBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        // 2、反射实例化newInstance();
        Object instance = instantiateBean(beanName, beanDefinition);
        // 3、封装成一个BeanWrapper
        GPBeanWrapper beanWrapper = new GPBeanWrapper(instance);
        // 4、保存到IoC容器
        factoryBeanInstanceCache.put(beanName, beanWrapper);
        // 5、执行依赖注入
        populateBean(beanName, beanDefinition, beanWrapper);

        return beanWrapper.getWrapperInstance();
    }

    private void populateBean(String beanName, GPBeanDefinition beanDefinition, GPBeanWrapper beanWrapper) {
        //可能涉及到循环依赖？
        //A{ B b}
        //B{ A b}
        //用两个缓存，循环两次
        //1、把第一次读取结果为空的BeanDefinition存到第一个缓存
        //2、等第一次循环之后，第二次循环再检查第一次的缓存，再进行赋值

        Object instance = beanWrapper.getWrapperInstance();

        Class<?> clazz = beanWrapper.getWrappedClass();

        //在Spring中@Component
        if (!(clazz.isAnnotationPresent(GPController.class) || clazz.isAnnotationPresent(GPService.class))) {
            return;
        }

        //把所有的包括private/protected/default/public 修饰字段都取出来
        for (Field field : clazz.getDeclaredFields()) {

            if (!field.isAnnotationPresent(GPAutowired.class)) {
                continue;
            }

            GPAutowired autowired = field.getAnnotation(GPAutowired.class);
            ;
            // 如果用户没有自定义的beanName，就默认根据类型注入
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)) {
                // field.getType().getName()获取字段类型
                autowiredBeanName = field.getType().getName();
            }

            //暴力访问
            field.setAccessible(true);
            try {
                if (this.factoryBeanInstanceCache.get(autowiredBeanName) == null) {
                    continue;
                }
                //ioc.get(beanName) 相当于通过接口的全名拿到接口的实现的实例
                field.set(instance, this.factoryBeanInstanceCache.get(autowiredBeanName).getWrapperInstance());

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    //创建真正的实例对象
    private Object instantiateBean(String beanName, GPBeanDefinition beanDefinition) {
        String className = beanDefinition.getBeanClassName();
        Object instance = null;
        try {
            if (this.factoryBeanObjectCache.containsKey(beanName)) {
                instance = this.factoryBeanObjectCache.get(beanName);
            } else {

                Class<?> clazz = Class.forName(className);
                // 2、默认的类名首字母小写
                instance = clazz.newInstance();

                // =============================AOP开始===========================
                // 如果满足条件，就直接返回Proxy对象
                // 1、加载AOP配置文件
                GPAdvisedSupport config = instantionAopConfig(beanDefinition);
                config.setTarget(instance);
                config.setTargetClass(clazz);

                //判断规则，要不要生成代理类，如果要就覆盖原生对象
                // 如果不要就不做任何处理，返回原生对象
                if (config.pointCutMatch()) {
                    instance = proxyFactory.createAopProxy(config).getProxy();
                }

                // ============================AOP结束============================
                this.factoryBeanObjectCache.put(beanName, instance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    private GPAdvisedSupport instantionAopConfig(GPBeanDefinition beanDefinition) {
        GPAopConfig config = new GPAopConfig();
        config.setPointCut(this.reader.getConfig().getProperty("pointCut"));
        config.setAspectClass(this.reader.getConfig().getProperty("aspectClass"));
        config.setAspectBefore(this.reader.getConfig().getProperty("aspectBefore"));
        config.setAspectAfter(this.reader.getConfig().getProperty("aspectAfter"));
        config.setAspectAfterThrow(this.reader.getConfig().getProperty("aspectAfterThrow"));
        config.setAspectAfterThrowingName(this.reader.getConfig().getProperty("aspectAfterThrowingName"));
        return new GPAdvisedSupport(config);
    }

    public int getBeanDefinitionCount() {
        return this.beanDefinitionMap.size();
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public Properties getConfig() {
        return this.reader.getConfig();
    }

}