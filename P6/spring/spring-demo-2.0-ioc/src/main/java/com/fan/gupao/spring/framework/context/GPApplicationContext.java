package com.fan.gupao.spring.framework.context;

import com.fan.gupao.spring.framework.annotation.GPAutowired;
import com.fan.gupao.spring.framework.annotation.GPController;
import com.fan.gupao.spring.framework.annotation.GPService;
import com.fan.gupao.spring.framework.beans.GPBeanWrapper;
import com.fan.gupao.spring.framework.beans.config.GPBeanDefinition;
import com.fan.gupao.spring.framework.beans.support.GPBeanDefinitionReader;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 职责:完成Bean的创建和DI
 *              按之前源码分析的套路，IOC、DI、MVC、AOP
 * @Author: 樊高风
 * @Date: 18:30 2020/4/3
 */
public class GPApplicationContext {

    private GPBeanDefinitionReader reader;

    //存储注册信息的BeanDefinition
    protected final Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    //单例的IOC容器缓存
    private Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    //通用的IOC容器
    private Map<String, GPBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>();


    public GPApplicationContext(String... configLocations) {
        //1、加载配置文件
        reader = new GPBeanDefinitionReader(configLocations);
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

    /**
     * 功能描述：依赖注入
     *
     * @authorer: 樊高风
     * @date: 2020/4/3 19:24
     * @param:
     * @return:
     */
    private void doAutowrited() {
        //调用getBean（）
        //这一步，所有的Bean并没有真正的实例化，还只是配置阶段
        for (Map.Entry<String, GPBeanDefinition> beanDefinitionEntry : this.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            getBean(beanName);
        }

    }

    /**
     * 功能描述:把BeanDefinition缓存起来
     *
     * @authorer: 樊高风
     * @date: 2020/4/3 19:17
     * @param:
     * @return:
     */
    private void doRegistBeanDefinition(List<GPBeanDefinition> beanDefinitions) throws Exception {
        for (GPBeanDefinition beanDefinition : beanDefinitions) {
            if (this.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new Exception("The" + beanDefinition.getFactoryBeanName() + "is exists");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(), beanDefinition);
        }

    }


    /**
     * 功能描述:Bean的实例化，DI是从这个方法开始的
     * 依赖注入，从这里开始，通过读取BeanDefinition中的信息
     * 然后，通过反射机制创建一个实例并返回
     * Spring做法是，不会把最原始的对象放出去，会用一个BeanWrapper来进行一次包装
     * 装饰器模式：
     * 1、保留原来的OOP关系
     * 2、我需要对它进行扩展，增强（为了以后AOP打基础）
     * @authorer: 樊高风
     * @date: 2020/4/3 19:27
     * @param:
     * @return:
     */
    public Object getBean(String beanName) {
        //1、先拿到BeanDefinition配置信息
        GPBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        //2、反射实例化newInstance();
        Object instance = instantiateBean(beanName, beanDefinition);
        //3、封装成一个叫做BeanWrapper
        GPBeanWrapper beanWrapper = new GPBeanWrapper(instance);
        //4、保存到IOC容器
        factoryBeanInstanceCache.put(beanName, beanWrapper);
        //5、执行依赖注入
        populateBean(beanName, beanDefinition, beanWrapper);
        return beanWrapper.getWrapperInstance();
    }

    /**
     * 功能描述：执行依赖注入
     *
     * @authorer: 樊高风
     * @date: 2020/4/3 19:46
     * @param:
     * @return:
     */
    private void populateBean(String beanName, GPBeanDefinition beanDefinition, GPBeanWrapper beanWrapper) {
        //可能涉及到循环依赖？
        //A{B b}
        //B{A b}
        //用俩个缓存，循环两次
        //1、把第一次读取结果为空的BeanDefinition存到第一个缓存
        //2、等第一次循环之后，第二次循环再检查第一次的缓存，再进行赋值

        Object instance = beanWrapper.getWrapperInstance();

        Class<?> clazz = beanWrapper.getWrappedClass();

        //在Spring中@Component
        boolean isCheck = (clazz.isAnnotationPresent(GPController.class) || clazz.isAnnotationPresent(GPService.class));
        if (!isCheck) {
            return;
        }

        //把所有的包括private/protected/default/public 修饰字段都取出来
        for (Field field : clazz.getDeclaredFields()) {
            if (!field.isAnnotationPresent(GPAutowired.class)) {
                continue;
            }

            GPAutowired autowired = field.getAnnotation(GPAutowired.class);

            //如果用户没有自定义的beanName,就默认根据类型注入
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)) {
                //field.getType().getName()获取字段的类型
                autowiredBeanName = field.getType().getName();
            }

            //暴力访问
            field.setAccessible(true);
            try {
                if (this.factoryBeanInstanceCache.get(autowiredBeanName) == null) {
                    continue;
                }
                //ioc.get(beanName)相当于通过接口的全名拿到接口的实现的实例
                field.set(instance, this.factoryBeanInstanceCache.get(autowiredBeanName).getWrapperInstance());
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

    }

    /**
     * 功能描述:创建真正的实例对象
     *
     * @authorer: 樊高风
     * @date: 2020/4/3 19:29
     * @param:
     * @return:
     */
    private Object instantiateBean(String beanName, GPBeanDefinition beanDefinition) {
        //1、拿到要实例化的对象的类名
        String className = beanDefinition.getBeanClassName();
        Object instance = null;
        try {
            //假设默认就是单例，细节暂且不考虑，先把主线拉通
            if(this.factoryBeanObjectCache.containsKey(className)){
                instance = this.factoryBeanObjectCache.get(className);
            }else {
                Class<?> clazz = Class.forName(className);
                //2、默认的类名首字母小写
                instance = clazz.newInstance();
                this.factoryBeanObjectCache.put(beanName, instance);
                this.factoryBeanObjectCache.put(beanDefinition.getFactoryBeanName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }


    public Object getBean(Class beanClass) {
        return getBean(beanClass.getName());
    }

}
