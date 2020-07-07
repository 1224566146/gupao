package com.fan.gupao.demo.jdbc.framework;

import java.sql.ResultSet;

/**
 * @author 樊高风
 * @date 2020/7/7
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs,int rowNum) throws Exception;

}
