package com.fan.gupao.demo.promotion;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class CouponStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("使用优惠卷抵扣");
    }
}
