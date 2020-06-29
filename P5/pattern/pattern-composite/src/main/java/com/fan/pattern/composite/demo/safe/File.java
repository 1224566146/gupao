package com.fan.pattern.composite.demo.safe;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
public class File extends Directory {
    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
