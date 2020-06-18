package com.fan.gupao.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * @author 樊高风
 * @date 2020/6/18 14:09
 */
@Component
public class ReferenceInvokeProxy implements BeanPostProcessor {

    @Autowired
    RemoteInvocationHandler invocationHandler;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(GpReference.class)){
                field.setAccessible(true);
                // 针对这个加了GpReference的注解的字段，设置一个代理值
                Object proxy = Proxy.newProxyInstance(field.getType().getClassLoader(),
                        new Class<?>[]{field.getType()}, invocationHandler);
                try {
                    // 相当于针对加了GpReference的注解，设置了一个代理，这个代理的实现是inovcationHandler
                    field.set(bean, proxy);
                }catch (Exception e ){
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
