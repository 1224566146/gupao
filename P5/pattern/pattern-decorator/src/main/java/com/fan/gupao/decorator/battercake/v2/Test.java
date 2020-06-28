package com.fan.gupao.decorator.battercake.v2;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class Test {

    public static void main(String[] args) {

        Battercake battercake;

        battercake = new BaseBattercake();

        battercake = new EggDecorator(battercake);

        battercake = new EggDecorator(battercake);


        System.out.println(battercake.getMsg()+",总价:"+battercake.getPrice());

    }
}
