package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public class Invoker {

    private ICommand command;

    public Invoker(ICommand command) {
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }
}
