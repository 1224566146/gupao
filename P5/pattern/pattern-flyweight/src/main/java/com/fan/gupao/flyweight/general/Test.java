package com.fan.gupao.flyweight.general;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class Test {
    public static void main(String[] args) {
        IFlyweight flyweight1 = FlyweightFactory.getFlyweight("aa");
        IFlyweight flyweight2 = FlyweightFactory.getFlyweight("bb");

        flyweight1.operation("a");
        flyweight2.operation("b");
    }
}
