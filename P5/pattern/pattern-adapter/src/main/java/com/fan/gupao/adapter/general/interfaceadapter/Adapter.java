package com.fan.gupao.adapter.general.interfaceadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public abstract class Adapter implements Target {

    protected Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int request1() {
        return 0;
    }

    @Override
    public int request2() {
        return 0;
    }

    @Override
    public int request3() {
        return 0;
    }

    @Override
    public int request4() {
        return 0;
    }
}
