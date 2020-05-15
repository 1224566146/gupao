package com.fan.gupao.mybatis.v2.executor;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 12:43 2020/5/15
 */
public interface Executor {
    <T> T query(String statement, Object[] paramter, Class pojo);
}
