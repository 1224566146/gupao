package com.fan.gupao.pattern.factory.payfactory;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:51 2020/4/6
 */
public class ApplePay implements IPay {
    @Override
    public void doPay() {
        System.out.println("苹果支付");
    }
}
