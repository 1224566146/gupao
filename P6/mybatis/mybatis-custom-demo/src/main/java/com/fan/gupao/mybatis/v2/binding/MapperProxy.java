package com.fan.gupao.mybatis.v2.binding;

import com.fan.gupao.mybatis.v2.session.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: MapperProxy代理类，用于代理Mapper接口
 * @Author: 樊高风
 * @Date: 9:47 2020/5/15
 */
public class MapperProxy implements InvocationHandler {

    private DefaultSqlSession sqlSession;
    private Class object;

    public MapperProxy(DefaultSqlSession sqlSession, Class object) {
        this.sqlSession = sqlSession;
        this.object = object;
    }

    /**
     * 功能描述：所有Mapper接口的方法调用都会走到这里
     * @authorer: 樊高风
     * @date: 2020/5/15 9:48
     * @param proxy
     * @param method
     * @param args
     * @return:
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        // 如果根据接口类型+方法名能找到映射的SQL，则执行SQL
        if(sqlSession.getConfiguration().hasStatement(statementId)){
            return sqlSession.selectOne(statementId, args, object);
        }
        // 否则直接执行被代理对象的原方法
        return method.invoke(proxy, args);
    }
}
