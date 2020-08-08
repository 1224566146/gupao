package com.fan.gupao.demo.general.apply;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
public class ConcreteStateA extends State {


    @Override
    public void handle() {
        System.out.println("StateA do action");
        // A状态完成后自动切换到B状态
        this.context.setState(Context.STATE_B);
        this.context.getState().handle();
    }
}
