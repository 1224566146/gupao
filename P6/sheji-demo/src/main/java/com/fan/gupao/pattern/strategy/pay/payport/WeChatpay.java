package com.fan.gupao.pattern.strategy.pay.payport;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:13 2020/3/4
 */
public class WeChatpay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
