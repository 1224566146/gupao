package com.fan.pattern.composite.demo.safe;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
public abstract class Directory {

    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();
}
