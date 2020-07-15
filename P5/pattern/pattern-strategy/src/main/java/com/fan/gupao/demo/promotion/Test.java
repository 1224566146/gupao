package com.fan.gupao.demo.promotion;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class Test {

    public static void main(String[] args) {

        String promotion = "";

        PromotionStrategyFacory.getPromotionKeys();

        String promotionKey = "COUPON";

        IPromotionStrategy promotionStrategy = PromotionStrategyFacory.getPromotionStrategy(promotionKey);
        promotionStrategy.doPromotion();

    }
}
