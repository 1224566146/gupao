package com.fan.gupao.adapter.general.objectadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class Test {

    public static void main(String[] args) {

        Target adapter = new Adapter(new Adaptee());
        int result = adapter.request();
        System.out.println(result);

    }
}
