package com.fan.gupao.adapter.general.classadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public int request() {
        return super.specificRequest() / 10;
    }
}
