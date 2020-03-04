package com.fan.gupao.pattern.strategy.promotion;

/**
 * @Description:团购
 * @Author: 樊高风
 * @Date: 17:48 2020/3/4
 */
public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价");
    }
}
