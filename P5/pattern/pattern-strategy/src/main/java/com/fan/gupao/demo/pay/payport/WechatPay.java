package com.fan.gupao.demo.pay.payport;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 263;
    }
}
