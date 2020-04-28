package com.fan.gupao.spring.framework.aop.aspect;

import com.fan.gupao.spring.framework.aop.intercept.GPMethodInterceptor;
import com.fan.gupao.spring.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 21:52 2020/4/27
 */
public class GPAspectJAfterThrowingAdvice extends GPAbstractAspectJAdvice implements GPMethodInterceptor {

    private String throwName;

    public GPAspectJAfterThrowingAdvice(Object aspect, Method adviceMethod) {
        super(aspect, adviceMethod);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        try {

            return mi.proceed();

        }catch (Exception e){
            invokeAdviceMethod(mi, null, e.getCause());
            throw e;
        }
    }

    public void setThrowName(String throwName) {
        this.throwName = throwName;
    }
}
