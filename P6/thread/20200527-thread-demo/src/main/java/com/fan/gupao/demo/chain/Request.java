package com.fan.gupao.demo.chain;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:22 2020/5/28
 */
public class Request {

    private String name;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
