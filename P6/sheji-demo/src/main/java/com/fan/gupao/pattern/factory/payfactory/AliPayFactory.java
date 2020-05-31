package com.fan.gupao.pattern.factory.payfactory;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 18:09 2020/4/6
 */
public class AliPayFactory implements AbstractPayFactory {
    @Override
    public IPay createPay() {
        return new AliPay();
    }
}
