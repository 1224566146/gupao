package com.fan.gupao.mybatis.v2.binding;

import com.fan.gupao.mybatis.v2.session.DefaultSqlSession;

import java.lang.reflect.Proxy;

/**
 * @Description: 用于产生MapperProxy代理类
 * @Author: 樊高风
 * @Date: 9:52 2020/5/15
 */
public class MapperProxyFactory<T> {
    private Class<T> mapperInterface;
    private Class object;

    public MapperProxyFactory(Class<T> mapperInterface, Class object) {
        this.mapperInterface = mapperInterface;
        this.object = object;
    }

    public T newInstance(DefaultSqlSession sqlSession){
        return (T) Proxy.newProxyInstance(
                mapperInterface.getClassLoader(),
                new Class[]{mapperInterface},
                new MapperProxy(sqlSession, object)
        );
    }
}
