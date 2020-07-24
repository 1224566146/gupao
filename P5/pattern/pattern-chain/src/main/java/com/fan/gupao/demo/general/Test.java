package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public class Test {

    public static void main(String[] args) {

        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNextHandler(handlerB);
        handlerA.handleRequest("requestB");

    }
}
