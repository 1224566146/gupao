package com.fan.gupao.decorator.battercake.v1;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class BattercakeWithEgg extends Battercake {

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
