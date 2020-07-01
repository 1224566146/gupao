package com.fan.gupao.bridge.general;

/**
 * @author 樊高风
 * @date 2020/7/1
 */
public class Test {


    public static void main(String[] args) {


        // 来一个实现化角色
        IImplementor imp = new ConcreteImplementorA();
        // 来一个抽象化角色,聚合实现
        Abstraction abs = new RefinedAbstraction(imp);
        // 执行操作
        abs.operation();

    }
}
