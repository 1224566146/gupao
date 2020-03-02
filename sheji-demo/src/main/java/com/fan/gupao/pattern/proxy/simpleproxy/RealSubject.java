package com.fan.gupao.pattern.proxy.simpleproxy;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:33 2020/3/2
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real service is called.");
    }
}
