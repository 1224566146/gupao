package com.fan.gupao.demo.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class PojoEvent {


    @Subscribe
    public void observer(Pojo pojo){
        System.out.println("执行PojoEvent方法,传参为:"+pojo);
    }

}
