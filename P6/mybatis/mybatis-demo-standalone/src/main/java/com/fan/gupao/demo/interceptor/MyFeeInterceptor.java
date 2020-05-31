package com.fan.gupao.demo.interceptor;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:21 2020/5/13
 */
@Intercepts({@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class MyFeeInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("进入修改表名插件逻辑");

        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0]; // MappedStatement
        BoundSql boundSql = ms.getBoundSql(args[1]);// Object paramter

        Object parameterObject = boundSql.getParameterObject();
        Class<?> aClass = parameterObject.getClass();
//        Field feeDate = aClass.getDeclaredField("feeDate");
//        feeDate.setAccessible(true);
//        String value = (String) feeDate.get(parameterObject);
        String value = "";
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object valueObject = field.get(parameterObject);
            if (valueObject != null) {
                value = valueObject.toString();
            }
        }

        // 在SQL上修改表名
        String sql = boundSql.getSql();

        String[] froms = sql.split("where");
        String selectSql = froms[0].substring(0, froms[0].indexOf("from"));
        String tableSql = froms[0].substring(froms[0].indexOf("from")).trim();
        sql = selectSql + tableSql + "_" + value + " where " + froms[1];

        //自定义sqlSource
        SqlSource sqlSource = new StaticSqlSource(ms.getConfiguration(), sql, boundSql.getParameterMappings());

        //修改原来的sqlSource
        Field field = MappedStatement.class.getDeclaredField("sqlSource");
        field.setAccessible(true);
        field.set(ms, sqlSource);

        // 执行被拦截的方法
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
