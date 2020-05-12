package com.fan.gupao.demo.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:12 2020/5/12
 */
public class MyShopTypeHandler extends BaseTypeHandler<List<Integer>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        // 设置List类型的参数的时候调用，Java类型到JDBC类型
        // 注意只有在字段上添加typeHandler属性才会生效
        String string = parameter.toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "");
        System.out.println("-------------------" + string);

        ps.setString(i, string);


    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String string = rs.getString(columnName);

        return getArrayList(string);
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String string = rs.getString(columnIndex);

        return getArrayList(string);
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String string = cs.getString(columnIndex);

        return getArrayList(string);
    }

    private List<Integer> getArrayList(String str) {
        List<String> stringList = Arrays.asList(str.split(","));
        List<Integer> list = new ArrayList<>();
        for (String s : stringList) {
            list.add(Integer.parseInt(s.trim()));
        }
        return list;
    }

}
