package com.fan.gupao.spring.framework.beans;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:53 2020/4/13
 */
public class GPBeanWrapper {

    private Object wrapperInstance;

    private Class<?> wrappedClass;

    public GPBeanWrapper(Object wrapperInstance) {
        this.wrapperInstance = wrapperInstance;
        this.wrappedClass = wrapperInstance.getClass();
    }

    public Object getWrapperInstance() {
        return wrapperInstance;
    }

    public Class<?> getWrappedClass() {
        return wrappedClass;
    }
}
