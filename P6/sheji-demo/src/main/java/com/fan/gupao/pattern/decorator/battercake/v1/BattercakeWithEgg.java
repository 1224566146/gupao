package com.fan.gupao.pattern.decorator.battercake.v1;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:31 2020/3/9
 */
public class BattercakeWithEgg extends Battercake {

    protected String getMsg(){
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    //加一个鸡蛋加1块钱
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
