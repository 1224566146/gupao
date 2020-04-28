package com.fan.gupao.spring.framework.aop.aspect;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:40 2020/4/27
 */
public interface GPJoinPoint {

    Method getMethod();

    Object[] getArguments();

    Object getThis();

    void setUserAttribute(String key,Object value);

    Object getUserAttribute(String key);
}
