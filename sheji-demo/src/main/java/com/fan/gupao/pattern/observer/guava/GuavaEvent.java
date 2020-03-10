package com.fan.gupao.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 21:20 2020/3/9
 */
public class GuavaEvent {


    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，传入的参数是:"+str);
    }

}
