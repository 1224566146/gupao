package com.fan.gupao.decorator.battercake.v2;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class BattercakeDecorator extends Battercake {

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }

    @Override
    protected void doSomething() {

    }
}
