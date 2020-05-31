package com.fan.gupao.demo4;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:44 2020/5/26
 */
public class Hungry {

    private static final Hungry instance = new Hungry();

    private Hungry(){}

    public static Hungry getInstance(){
        return instance;
    }

}
