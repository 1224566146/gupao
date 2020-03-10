package com.fan.gupao.pattern.decorator.battercake.v1;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:34 2020/3/9
 */
public class BattercakeTest {


    public static void main(String[] args) {


        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() +"，总价格:"+battercake.getPrice());

        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg() +"，总价格:"+battercakeWithEgg.getPrice());

        BattercakeWithEggAndSausage battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
        System.out.println(battercakeWithEggAndSausage.getMsg() +"，总价格:"+battercakeWithEggAndSausage.getPrice());



    }

}
