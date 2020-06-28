package com.fan.gupao.decorator.battercake.v2;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class ToufuDecorator extends BattercakeDecorator {
    public ToufuDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1块臭豆腐";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+3;
    }
}
