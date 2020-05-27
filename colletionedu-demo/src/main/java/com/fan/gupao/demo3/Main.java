package com.fan.gupao.demo3;

import java.util.HashMap;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:11 2020/5/27
 */
public class Main {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1001, "seven");
        hashMap.put(1002, "rose");

        System.out.println(hash(11111520));

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
