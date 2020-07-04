package com.fan.gupao.delegate.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/4
 */
public class ConcreteB implements Task {
    @Override
    public void doTask() {
        System.out.println("执行,由B实现");
    }
}
