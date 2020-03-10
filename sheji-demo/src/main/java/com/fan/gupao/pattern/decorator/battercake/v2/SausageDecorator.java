package com.fan.gupao.pattern.decorator.battercake.v2;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:41 2020/3/9
 */
public class SausageDecorator extends BattercakeDecorator {

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomethind() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1根火腿";
    }

    @Override
    public int getPrice() {
        return super.getPrice() +2;
    }
}
