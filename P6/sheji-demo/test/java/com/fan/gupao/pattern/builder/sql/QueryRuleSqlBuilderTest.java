package com.fan.gupao.pattern.builder.sql;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:24 2020/5/19
 */
public class QueryRuleSqlBuilderTest {

    public static void main(String[] args) {

        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addAscOrder("age");
        queryRule.andEqual("addr", "beijing");
        queryRule.andLike("name", "1312");

        QueryRuleSqlBuilder builder = new QueryRuleSqlBuilder(queryRule);

        String t_member = builder.builder("t_member");
        System.out.println(t_member);

        System.out.println("Paramters:"+ Arrays.toString(builder.getValues()));


    }
}
