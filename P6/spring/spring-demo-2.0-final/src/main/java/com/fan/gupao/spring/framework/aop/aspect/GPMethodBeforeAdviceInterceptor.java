package com.fan.gupao.spring.framework.aop.aspect;

import com.fan.gupao.spring.framework.aop.intercept.GPMethodInterceptor;
import com.fan.gupao.spring.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 21:55 2020/4/27
 */
public class GPMethodBeforeAdviceInterceptor extends GPAbstractAspectJAdvice implements GPMethodInterceptor {

    private GPJoinPoint jp;

    public GPMethodBeforeAdviceInterceptor(Object aspect, Method adviceMethod) {
        super(aspect, adviceMethod);
    }

    public void before(Method method,Object[] args,Object target)throws Throwable{
        this.invokeAdviceMethod(this.jp,null,null );

    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        jp = mi;
        this.before(mi.getMethod(), mi.getArguments(), mi.getThis());
        return mi.proceed();
    }
}
