package com.fan.gupao.demo4;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:45 2020/5/26
 */
public class Lazy {

    private static Lazy instance;

    private Lazy(){}

    public static Lazy getInstance(){
        if(instance == null){
            synchronized (Lazy.class){
                if(instance == null){
                    instance = new Lazy();
                }
            }
        }
        return instance;
    }

}
