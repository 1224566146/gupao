package com.fan.gupao.adapter.demo.power.interfaceadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class Test {

    public static void main(String[] args) {


        DC adapter = new PowerAdapter(new AC220());
        adapter.output5V();

    }
}
