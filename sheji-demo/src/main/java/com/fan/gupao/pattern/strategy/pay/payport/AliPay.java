package com.fan.gupao.pattern.strategy.pay.payport;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:08 2020/3/4
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500;
    }
}
