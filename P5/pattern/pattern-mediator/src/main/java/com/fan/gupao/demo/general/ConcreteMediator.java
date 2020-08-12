package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class ConcreteMediator extends Mediator {
    @Override
    public void transferA() {
        // 协调行为:A转发到B
        this.colleagueB.selfMethodB();
    }

    @Override
    public void transferB() {
        // 协调行为:B转发到A
        this.colleagueA.selfMethodA();
    }
}
