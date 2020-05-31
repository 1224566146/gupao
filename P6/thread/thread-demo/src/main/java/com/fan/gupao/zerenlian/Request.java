package com.fan.gupao.zerenlian;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:01 2019/10/15
 */
public class Request {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
