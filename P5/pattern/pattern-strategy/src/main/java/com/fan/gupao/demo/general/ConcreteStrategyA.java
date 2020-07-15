package com.fan.gupao.demo.general;

/**
 * 具体策略类 ConcreteStrategy
 * @author 樊高风
 * @date 2020/7/15
 */
public class ConcreteStrategyA implements IStrategy {
    @Override
    public void algorithm() {
        System.out.println("Strategy A");
    }
}
