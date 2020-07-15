package com.fan.gupao.demo.promotion;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class EmptyStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无优惠");
    }
}
