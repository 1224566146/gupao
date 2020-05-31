package com.fan.gupao.demo.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:39 2020/5/8
 */
public class MyTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String paramter, JdbcType jdbcType) throws SQLException {
        // 设置 String 类型的参数的时候调用，Java类型到JDBC类型
        // 注意只有在字段上添加typeHandler属性才会生效
        // insertBlog name 字段
        System.out.println("--------------------------setNonNullParamter1:"+paramter);
        preparedStatement.setString(i, paramter);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        // 根据列名获取 String 类型的参数的时候调用，JDBC类型到Java类型
        // 注意只有在字段上添加typeHandler属性才会生效
        System.out.println("--------------------------getNullableResult1:"+columnName);
        return resultSet.getString(columnName);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        // 根据下标获取 String 类型的参数的时候调用
        System.out.println("--------------------------getNullableResult2:"+columnIndex);
        return resultSet.getString(columnIndex);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        System.out.println("-----------------------getNullableResult3:"+columnIndex);
        return callableStatement.getString(columnIndex);
    }
}
