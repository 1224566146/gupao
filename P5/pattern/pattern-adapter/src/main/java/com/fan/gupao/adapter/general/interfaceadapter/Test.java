package com.fan.gupao.adapter.general.interfaceadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class Test {

    public static void main(String[] args) {


        Target adapter = new Adapter(new Adaptee()){
            @Override
            public int request1() {
                return adaptee.specificRequest() / 10;
            }
        };
        int result =adapter.request1();
        System.out.println(result);

    }
}
