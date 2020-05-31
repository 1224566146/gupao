package com.fan.gupao.spring.framework.aop;

import com.fan.gupao.spring.framework.aop.intercept.GPMethodInvocation;
import com.fan.gupao.spring.framework.aop.support.GPAdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:27 2020/4/28
 */
public class GPJdkDynamicAopProxy implements GPAopProxy, InvocationHandler {

    private GPAdvisedSupport advised;

    public GPJdkDynamicAopProxy(GPAdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        return getProxy(this.getClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader, this.advised.getTargetClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, this.advised.getTargetClass());

        GPMethodInvocation invocation = new GPMethodInvocation(proxy, this.advised.getTarget(), method, args, this.advised.getTargetClass(),chain);


        return invocation.proceed();
    }
}
