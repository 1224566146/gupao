package com.fan.gupao.decorator.general;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class Client {
    public static void main(String[] args) {

        // 首先创建需要被装饰的原始对象(即要被装饰的对象)
        Component c1 = new ConcreteComponent();
        // 给对象透明的增加功能A并调用
        Decorator decoratorA = new ConcreteDecoratorA(c1);
        decoratorA.operation();

        // 给对象透明的增加功能B并调用
        Decorator decoratorB = new ConcreteDecoratorB(c1);
        decoratorB.operation();
        // 装饰器也可以装饰具体的装饰对象,此时相当于给对象在增加A的功能基础上再添加功能B
        Decorator decoratorBandA = new ConcreteDecoratorB(decoratorA);
        decoratorBandA.operation();
    }
}
