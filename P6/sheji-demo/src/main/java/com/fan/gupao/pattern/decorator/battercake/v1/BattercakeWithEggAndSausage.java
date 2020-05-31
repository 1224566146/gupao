package com.fan.gupao.pattern.decorator.battercake.v1;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:32 2020/3/9
 */
public class BattercakeWithEggAndSausage extends BattercakeWithEgg {


    @Override
    protected String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
