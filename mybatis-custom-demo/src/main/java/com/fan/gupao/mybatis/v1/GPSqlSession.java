package com.fan.gupao.mybatis.v1;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:07 2020/5/14
 */
public class GPSqlSession {

    private GPConfiguration configuration;

    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T>T selectOne(String statementId, Object paramter){
        // 每次都创建一个statementId
        String sql = GPConfiguration.SQL_MAPPINGS.getString(statementId);
        if(sql != null && !"".equals(sql)){
            return executor.query(sql, paramter);
        }
        return null;
    }

    public <T>T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }
}
