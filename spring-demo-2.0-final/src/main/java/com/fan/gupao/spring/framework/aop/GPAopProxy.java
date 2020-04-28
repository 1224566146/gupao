package com.fan.gupao.spring.framework.aop;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:24 2020/4/28
 */
public interface GPAopProxy {

    Object getProxy();

    Object getProxy(ClassLoader classLoader);

}
