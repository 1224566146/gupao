package com.fan.gupao.mybatis.v2.session;

/**
 * @Description: 会话工厂类，用于解析配置文件，产生Sqlsession
 * @Author: 樊高风
 * @Date: 11:04 2020/5/15
 */
public class SqlSessionFactory {
    private Configuration configuration;

    /**
     * 功能描述：build方法用于初始化Configuration，解析配置文件的工作在Configuration的构造函数中
     * @authorer: 樊高风
     * @date: 2020/5/15 11:05
     * @param:
     * @return:
     */
    public SqlSessionFactory build(){
        configuration = new Configuration();
        return this;
    }

    /**
     * 功能描述：获取DefaultSqlSession
     * @authorer: 樊高风
     * @date: 2020/5/15 11:05
     * @param:
     * @return:
     */
    public DefaultSqlSession openSqlSession(){
        return new DefaultSqlSession(configuration);
    }
}
