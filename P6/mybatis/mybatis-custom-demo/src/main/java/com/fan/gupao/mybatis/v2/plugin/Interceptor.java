package com.fan.gupao.mybatis.v2.plugin;

/**
 * @Description: 拦截器接口，所有自定义拦截器必须实现此接口
 * @Author: 樊高风
 * @Date: 13:13 2020/5/15
 */
public interface Interceptor {

    /**
     * 功能描述：插件的核心逻辑实现
     * @authorer: 樊高风
     * @date: 2020/5/15 13:14
     * @param:
     * @return:
     */
    Object intercept(Invocation invocation) throws Throwable;

    /**
     * 功能描述：对被拦截对象进行代理
     * @authorer: 樊高风
     * @date: 2020/5/15 13:14
     * @param:
     * @return:
     */
    Object plugin(Object target);
}
