package com.fan.gupao.pattern.proxy.dynamicproxy.jdkproxy;

import com.fan.gupao.pattern.proxy.Person;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:06 2020/3/2
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
