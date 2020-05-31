package com.fan.gupao.demo6;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:56 2020/5/26
 */
public class BeanConfig {

    private String id;
    private String clazz;
    private String factoryMethod;
    private String factoryBean;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }
}
