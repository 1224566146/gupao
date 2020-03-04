package com.fan.gupao.pattern.strategy.promotion;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:43 2020/3/4
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
