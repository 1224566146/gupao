package com.fan.gupao.demo.methodparam;

import java.util.HashMap;

/**
 * @author 樊高风
 * @date 2020/6/19 21:02
 */
public class Child extends Base{

    public void method(HashMap map) {
        System.out.println("执行子类hashMap入参方法");
    }
}
