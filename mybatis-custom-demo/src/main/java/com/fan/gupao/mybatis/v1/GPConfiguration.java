package com.fan.gupao.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:07 2020/5/14
 */
public class GPConfiguration {

    public static final ResourceBundle SQL_MAPPINGS;

    static {
        SQL_MAPPINGS = ResourceBundle.getBundle("v1sql");
    }

    public <T> T getMapper(Class clazz, GPSqlSession gpSqlSession) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new GPMapperProxy(gpSqlSession)
        );
    }
}
