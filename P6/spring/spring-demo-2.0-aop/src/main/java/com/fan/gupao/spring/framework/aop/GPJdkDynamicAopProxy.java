package com.fan.gupao.spring.framework.aop;

import com.fan.gupao.spring.framework.aop.aspect.GPAdvice;
import com.fan.gupao.spring.framework.aop.support.GPAdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:54 2020/4/13
 */
public class GPJdkDynamicAopProxy implements InvocationHandler {

    private GPAdvisedSupport config;

    public GPJdkDynamicAopProxy(GPAdvisedSupport config) {
        this.config = config;
    }

    public Object getProxy() {

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), this.config.getTargetClass().getInterfaces(),this );

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Map<String, GPAdvice>  advices = config.getAdvices(method, null);

        Object returnValue;
        try {

            invokeAdvice(advices.get("before"));

            returnValue = method.invoke(this.config.getTarget(), args);


            invokeAdvice(advices.get("after"));
        }catch (Exception e){
            invokeAdvice(advices.get("afterThrow"));
            throw e;

        }

        return returnValue;
    }


    private void invokeAdvice(GPAdvice advice){

        try {

            advice.getAdviceMthod().invoke(advice.getAspect(), null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
