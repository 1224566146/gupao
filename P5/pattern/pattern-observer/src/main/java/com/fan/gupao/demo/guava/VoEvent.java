package com.fan.gupao.demo.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class VoEvent {


    @Subscribe
    public void observer(Vo vo){
        System.out.println("执行VoEvent方法,传参为:"+vo);
    }

}
