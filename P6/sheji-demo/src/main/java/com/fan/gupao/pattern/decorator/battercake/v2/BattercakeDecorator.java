package com.fan.gupao.pattern.decorator.battercake.v2;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:38 2020/3/9
 */
public abstract class BattercakeDecorator extends Battercake {

    //静态代理、委派
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomethind();

    @Override
    protected String getMsg() {
        return battercake.getMsg();
    }

    @Override
    public int getPrice() {
        return battercake.getPrice();
    }
}
