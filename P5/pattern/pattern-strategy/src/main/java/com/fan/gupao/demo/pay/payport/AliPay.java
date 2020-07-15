package com.fan.gupao.demo.pay.payport;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
