package com.fan.gupao.spi.mysql;

import com.fan.gupao.spi.DataBaseDriver;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
public class MysqlDriver implements DataBaseDriver {
    @Override
    public String buildConnect(String s) {
        return "Mysql的驱动实现:"+s;
    }
}
