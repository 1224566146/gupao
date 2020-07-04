package com.fan.gupao.delegate.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/4
 */
public class ConcreteA implements Task {
    @Override
    public void doTask() {
        System.out.println("执行,由A实现");
    }
}
