package com.fan.gupao.pattern.decorator.battercake.v2;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:36 2020/3/9
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
