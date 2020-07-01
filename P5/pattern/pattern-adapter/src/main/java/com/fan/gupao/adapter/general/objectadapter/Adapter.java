package com.fan.gupao.adapter.general.objectadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int request() {
        return adaptee.specificRequest() / 10;
    }
}
