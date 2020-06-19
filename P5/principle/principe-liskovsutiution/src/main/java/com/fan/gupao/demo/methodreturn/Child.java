package com.fan.gupao.demo.methodreturn;

import java.util.HashMap;

/**
 * @author 樊高风
 * @date 2020/6/19 21:09
 */
public class Child extends Base {
    @Override
    public HashMap method() {
        HashMap hashMap = new HashMap();
        System.out.println("执行子类的method");
        hashMap.put("msg","子类method");
        return hashMap;
    }
}
