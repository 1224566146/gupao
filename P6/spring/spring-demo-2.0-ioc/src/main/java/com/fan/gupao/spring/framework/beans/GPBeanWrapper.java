package com.fan.gupao.spring.framework.beans;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:39 2020/4/3
 */
public class GPBeanWrapper {

    private Object wrapperInstance;

    private Class<?> wrappedClass;

    public GPBeanWrapper(Object instance) {
        this.wrapperInstance = instance;
        this.wrappedClass = instance.getClass();
    }

    public Object getWrapperInstance() {
        return wrapperInstance;
    }


    public Class<?> getWrappedClass() {
        return wrappedClass;
    }


}
