package com.fan.gupao.pattern.template.jdbc;

import java.sql.ResultSet;

/**
 * @Description: ORM映射定制化的接口
 * @Author: 樊高风
 * @Date: 19:37 2020/3/6
 */
public interface RowMapper<T> {


    T mapRow(ResultSet rs,int rowNum) throws Exception;

}
