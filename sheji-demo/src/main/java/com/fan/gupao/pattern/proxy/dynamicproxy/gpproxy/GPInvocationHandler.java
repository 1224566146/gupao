package com.fan.gupao.pattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:35 2020/3/2
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
