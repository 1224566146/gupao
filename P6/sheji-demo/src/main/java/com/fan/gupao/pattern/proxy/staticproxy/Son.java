package com.fan.gupao.pattern.proxy.staticproxy;

import com.fan.gupao.pattern.proxy.Person;

/**
 * @Description: 静态代理
 * @Author: 樊高风
 * @Date: 15:23 2020/3/2
 */
public class Son implements Person {
    @Override
    public void findLove() {
        System.out.println("儿子要求:肤白貌美大长腿");
    }

    public void findJob(){

    }

    public void eat(){

    }
}
