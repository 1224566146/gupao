package com.fan.gupao.pattern.prototype.deep;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:38 2020/2/19
 */
public class JinGuBang implements Serializable {

    private float h = 100;

    private float d = 10;

    public void big() {
        this.d = d * 2;
        this.h = h * 2;
    }

    public void small() {
        this.d = d / 2;
        this.h = h / 2;
    }

}
