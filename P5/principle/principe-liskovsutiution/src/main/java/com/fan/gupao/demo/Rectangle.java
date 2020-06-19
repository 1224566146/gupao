package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/19 20:27
 */
public class Rectangle implements QuadRangle {

    private long height;

    private long width;

    public void setHeight(long height) {
        this.height = height;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    @Override
    public long getWidth() {
        return width;
    }

    @Override
    public long getHeight() {
        return height;
    }
}
