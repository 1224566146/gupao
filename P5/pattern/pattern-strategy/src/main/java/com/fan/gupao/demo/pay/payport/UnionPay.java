package com.fan.gupao.demo.pay.payport;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
