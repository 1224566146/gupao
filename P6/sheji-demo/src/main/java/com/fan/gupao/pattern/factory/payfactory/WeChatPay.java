package com.fan.gupao.pattern.factory.payfactory;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:49 2020/4/6
 */
public class WeChatPay implements IPay {
    @Override
    public void doPay() {
        System.out.println("微信支付");
    }
}
