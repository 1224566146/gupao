package com.fan.gupao.spring.framework.beans.config;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 18:39 2020/4/3
 */
public class GPBeanDefinition {

    private String factoryBeanName;

    private String beanClassName;

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
