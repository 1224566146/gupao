package com.fan.gupao.mybatis.v2.executor;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 12:46 2020/5/15
 */
public class SimpleExecutor implements Executor {
    @Override
    public <T> T query(String statement, Object[] paramter, Class pojo) {
        StatementHandler statementHandler = new StatementHandler();
        return statementHandler.query(statement, paramter, pojo);
    }
}
