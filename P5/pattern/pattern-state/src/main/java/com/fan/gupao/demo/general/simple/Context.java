package com.fan.gupao.demo.general.simple;

/**
 * 环境类
 * @author 樊高风
 * @date 2020/8/8
 */
public class Context {

    private static final IState STATE_A = new ConcreteStateA();
    private static final IState STATE_B = new ConcreteStateB();

    // 默认状态A
    private IState currentState = STATE_A;

    public void setState(IState state){
        this.currentState = state;
    }

    public void handle(){
        this.currentState.handle();
    }

}
