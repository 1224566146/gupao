package com.fan.gupao.demo6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:59 2020/5/26
 */
public class Init {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        // 模拟解析xml   拿到beanConfigs
        List<BeanConfig> beanConfigs = parseXmltoBeanConfig();

        //循环
        for (BeanConfig beanConfig : beanConfigs) {
            if(beanConfig.getClazz() != null){
                // 拿到clazz
                Class<?> clazz = Class.forName(beanConfig.getClazz());
                if(beanConfig.getFactoryMethod() != null){
                    // 基于Class对象获取Method对象
                    Method method = clazz.getDeclaredMethod(beanConfig.getFactoryMethod());
                    IOCContainer.putBean(beanConfig.getId(), method.invoke(null));
                }else{
                    // 构造器构造实例
                    IOCContainer.putBean(beanConfig.getId(), clazz.newInstance());

                }
            }else if(beanConfig.getFactoryBean() != null){
                // 从容器中拿到实体的Bean
                Object bean = IOCContainer.getBean(beanConfig.getFactoryBean());
                Method method = bean.getClass().getDeclaredMethod(beanConfig.getFactoryMethod());

                IOCContainer.putBean(beanConfig.getId(), method.invoke(bean));
            }else{
                System.out.println("核心配置都没有");
            }
        }


    }





    /**
     * 模拟一个解析XML过程
     *
     * @return
     */
    private static List<BeanConfig> parseXmltoBeanConfig() {

        //TODO
        List<BeanConfig> beanConfigs = new ArrayList<BeanConfig>();
        BeanConfig beanConfig1 = new BeanConfig();
        beanConfig1.setClazz("com.fan.gupao.demo5.A");
        beanConfig1.setId("a");
        beanConfigs.add(beanConfig1);


        BeanConfig beanConfig2 = new BeanConfig();
        beanConfig2.setClazz("com.fan.gupao.demo5.A");
        beanConfig2.setId("b");
        beanConfig2.setFactoryMethod("createBObj");
        beanConfigs.add(beanConfig2);


        BeanConfig beanConfig3 = new BeanConfig();
        beanConfig3.setId("c");
        beanConfig3.setFactoryBean("a");
        beanConfig3.setFactoryMethod("createCObj");
        beanConfigs.add(beanConfig3);

        return beanConfigs;
    }
}
