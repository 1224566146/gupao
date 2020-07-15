package com.fan.gupao.demo.promotion;

/**
 *
 * @author 樊高风
 * @date 2020/7/15
 */
public class CashbackStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现,直接打款到支付宝账号");
    }
}
