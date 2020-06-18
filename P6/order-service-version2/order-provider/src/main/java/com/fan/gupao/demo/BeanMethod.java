package com.fan.gupao.demo;

import java.lang.reflect.Method;

/**
 * @author 樊高风
 * @date 2020/6/18 13:38
 */
public class BeanMethod {

    private Object bean;

    private Method method;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
