package com.fan.gupao.demo.general.apply;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
public class Context {

    public static final State STATE_A = new ConcreteStateA();

    public static final State STATE_B = new ConcreteStateB();

    private State currentState = STATE_A;
    {
        STATE_A.setContext(this);
        STATE_B.setContext(this);
    }

    public void setState(State state){
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public State getState(){
        return this.currentState;
    }

    public void handle(){
        this.currentState.handle();
    }
}
