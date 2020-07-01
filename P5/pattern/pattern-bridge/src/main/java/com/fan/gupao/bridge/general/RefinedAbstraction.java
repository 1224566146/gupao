package com.fan.gupao.bridge.general;

/**
 * 修正抽象
 * @author 樊高风
 * @date 2020/7/1
 */
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(IImplementor iImplementor) {
        super(iImplementor);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("refined operation");
    }
}
