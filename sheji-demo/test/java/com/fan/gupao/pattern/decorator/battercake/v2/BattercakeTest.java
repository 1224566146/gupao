package com.fan.gupao.pattern.decorator.battercake.v2;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:43 2020/3/9
 */
public class BattercakeTest {

    public static void main(String[] args) {

        Battercake battercake;

        battercake = new BaseBattercake();



        battercake = new EggDecorator(battercake);
        battercake = new EggDecorator(battercake);
        battercake = new EggDecorator(battercake);



        System.out.println(battercake.getMsg()+",总价格:"+battercake.getPrice());


    }
}
