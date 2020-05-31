package com.fan.gupao.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:14 2020/5/14
 */
public class GPMapperProxy implements InvocationHandler {

    private GPSqlSession gpSqlSession;

    public GPMapperProxy(GPSqlSession gpSqlSession) {
        this.gpSqlSession = gpSqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        return gpSqlSession.selectOne(statementId, args[0]);
    }
}
