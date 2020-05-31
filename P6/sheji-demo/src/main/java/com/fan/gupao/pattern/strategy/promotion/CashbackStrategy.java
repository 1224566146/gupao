package com.fan.gupao.pattern.strategy.promotion;

/**
 * @Description:返现活动
 * @Author: 樊高风
 * @Date: 17:45 2020/3/4
 */
public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账号");
    }
}
