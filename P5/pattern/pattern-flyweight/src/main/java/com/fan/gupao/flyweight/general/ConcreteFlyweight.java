package com.fan.gupao.flyweight.general;

/**
 * 具体享元角色
 * @author 樊高风
 * @date 2020/6/28
 */
public class ConcreteFlyweight implements IFlyweight {

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Object address:"+System.identityHashCode(this));
        System.out.println("IntrinsicState:"+this.intrinsicState);
        System.out.println("ExtrinsicState:"+extrinsicState);
    }
}
