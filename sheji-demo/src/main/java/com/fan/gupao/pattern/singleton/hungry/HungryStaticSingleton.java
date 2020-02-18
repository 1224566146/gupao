package com.fan.gupao.pattern.singleton.hungry;

/**
 * @Description: 饿汉式静态块单例
 * @Author: 樊高风
 * @Date: 14:29 2020/2/16
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton hungryStaticSingleton;

    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {

    }

    public static HungryStaticSingleton getInstance() {
        return hungryStaticSingleton;
    }

}
