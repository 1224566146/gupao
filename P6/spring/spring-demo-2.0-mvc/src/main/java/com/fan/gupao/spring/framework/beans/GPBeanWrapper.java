package com.fan.gupao.spring.framework.beans;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:10 2020/4/11
 */
public class GPBeanWrapper {

    private Object wrapperInstance;

    private Class<?> wrapperdClass;

    public GPBeanWrapper(Object wrapperInstance) {
        this.wrapperInstance = wrapperInstance;
        this.wrapperdClass = wrapperInstance.getClass();
    }

    public Object getWrapperInstance() {
        return wrapperInstance;
    }

    public Class<?> getWrapperdClass() {
        return wrapperdClass;
    }
}
