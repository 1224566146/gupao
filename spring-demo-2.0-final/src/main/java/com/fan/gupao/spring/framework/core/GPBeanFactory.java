package com.fan.gupao.spring.framework.core;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:51 2020/4/27
 */
public interface GPBeanFactory {

    Object getBean(Class beanClass);

    Object getBean(String beanName);
}
