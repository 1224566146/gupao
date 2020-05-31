package com.fan.gupao.spring.framework.aop.intercept;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:44 2020/4/27
 */
public interface GPMethodInterceptor {

    Object invoke(GPMethodInvocation invocation) throws Throwable;

}
