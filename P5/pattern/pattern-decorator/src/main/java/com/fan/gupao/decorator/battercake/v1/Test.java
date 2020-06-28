package com.fan.gupao.decorator.battercake.v1;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class Test {

    public static void main(String[] args) {


        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg()+",总价:"+battercake.getPrice());

        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg+",总价:"+battercakeWithEgg.getPrice());

        BattercakeWithEggAndSauage battercakeWithEggAndSauage = new BattercakeWithEggAndSauage();
        System.out.println(battercakeWithEggAndSauage.getMsg()+",总价:"+battercakeWithEggAndSauage.getPrice());

    }
}
