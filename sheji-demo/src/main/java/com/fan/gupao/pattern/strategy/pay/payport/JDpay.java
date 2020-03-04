package com.fan.gupao.pattern.strategy.pay.payport;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:12 2020/3/4
 */
public class JDpay extends Payment {
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 150;
    }
}
