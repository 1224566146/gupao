package com.fan.gupao.decorator.battercake.v2;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class SauageDecorator extends BattercakeDecorator {
    public SauageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
