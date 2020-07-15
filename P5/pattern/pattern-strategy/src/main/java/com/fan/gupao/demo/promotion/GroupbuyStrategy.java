package com.fan.gupao.demo.promotion;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class GroupbuyStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("5人成团,可以优惠");
    }
}
