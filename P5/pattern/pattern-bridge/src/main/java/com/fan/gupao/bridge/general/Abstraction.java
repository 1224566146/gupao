package com.fan.gupao.bridge.general;

/**
 * 抽象
 * @author 樊高风
 * @date 2020/7/1
 */
public abstract class Abstraction {

    protected IImplementor iImplementor;

    public Abstraction(IImplementor iImplementor) {
        this.iImplementor = iImplementor;
    }

    public void operation(){
        this.iImplementor.operationImpl();
    }
}
