package com.fan.gupao.pattern.adapter.poweradapter;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:12 2020/3/6
 */
public class PowerAdapterTest {

    public static void main(String[] args) {

        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5V();

    }
}
