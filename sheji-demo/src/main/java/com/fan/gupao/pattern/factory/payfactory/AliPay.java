package com.fan.gupao.pattern.factory.payfactory;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:48 2020/4/6
 */
public class AliPay implements IPay {
    @Override
    public void doPay() {
        System.out.println("支付宝支付");
    }
}
