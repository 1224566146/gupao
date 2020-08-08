package com.fan.gupao.demo.general.simple;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
public class ConcreteStateA implements IState {
    @Override
    public void handle() {
        // 必要时刻需要进行状态切换
        System.out.println("StateA do action");
    }
}
