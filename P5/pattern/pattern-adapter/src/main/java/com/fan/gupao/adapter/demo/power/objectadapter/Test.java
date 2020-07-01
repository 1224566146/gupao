package com.fan.gupao.adapter.demo.power.objectadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class Test {

    public static void main(String[] args) {

        DC5 adapter = new PowerAdapter(new AC220());
        adapter.output5V();

    }
}
