package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/19 20:29
 */
public class Square implements QuadRangle {

    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getWidth() {
        return length;
    }

    @Override
    public long getHeight() {
        return length;
    }
}
