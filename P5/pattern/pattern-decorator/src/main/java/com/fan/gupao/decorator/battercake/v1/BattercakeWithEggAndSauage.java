package com.fan.gupao.decorator.battercake.v1;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class BattercakeWithEggAndSauage extends BattercakeWithEgg {
    @Override
    protected String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
