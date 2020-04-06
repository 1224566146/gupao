package com.fan.gupao.pattern.factory.payfactory;

import com.fan.gupao.pattern.factory.payfactory.IPay;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:50 2020/4/6
 */
public class UnionPay implements IPay {
    @Override
    public void doPay() {
        System.out.println("银联支付");
    }
}
