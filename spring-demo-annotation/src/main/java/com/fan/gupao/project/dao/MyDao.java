package com.fan.gupao.project.dao;

import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:23 2020/4/14
 */
@Repository
public class MyDao {

    private String flag = "1";

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MyDao{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
