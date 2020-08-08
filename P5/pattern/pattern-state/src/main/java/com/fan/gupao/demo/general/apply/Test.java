package com.fan.gupao.demo.general.apply;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
public class Test {

    public static void main(String[] args) {

        Context context = new Context();
        context.setState(new ConcreteStateA());
        context.handle();
    }
}
