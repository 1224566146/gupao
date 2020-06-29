package com.fan.pattern.composite.general.safe;

/**
 * 抽象根节点
 * @author 樊高风
 * @date 2020/6/29
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String operation();
}
