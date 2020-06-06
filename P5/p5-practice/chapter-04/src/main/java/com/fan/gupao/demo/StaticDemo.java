package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: StaticDemo
 * @ProjectName p5-practice
 * @Description: StaticDemo
 * @date 2020/6/6 14:50
 */
public class StaticDemo {

    private StaticDemo(){}

    private static StaticDemo instance = new StaticDemo();
    public static StaticDemo getInstance(){
        return instance;
    }

}
