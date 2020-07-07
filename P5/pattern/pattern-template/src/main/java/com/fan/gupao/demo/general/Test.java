package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/7
 */
public class Test {

    public static void main(String[] args) {

        AbstractClass abc = new ConcreteClassA();
        abc.templateMethod();

        abc = new ConcreteClassB();
        abc.templateMethod();

    }
}
