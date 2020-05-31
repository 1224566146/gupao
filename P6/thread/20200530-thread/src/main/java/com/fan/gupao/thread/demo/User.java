package com.fan.gupao.thread.demo;

/**
 * @author 樊高风
 * @Title: User
 * @ProjectName 20200530-thread
 * @Description: TODO
 * @date 2020/5/31 16:20
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
