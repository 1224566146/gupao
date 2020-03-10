package com.fan.gupao.pattern.decorator.battercake.v2;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:40 2020/3/9
 */
public class EggDecorator extends BattercakeDecorator {



    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomethind() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+1;
    }
}
