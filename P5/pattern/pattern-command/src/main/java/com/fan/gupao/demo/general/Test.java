package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public class Test {

    public static void main(String[] args) {


        ICommand command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.action();

    }

}
