package com.fan.gupao.decorator.battercake.v2;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }

    @Override
    protected void doSomething() {

    }
}
