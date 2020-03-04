package com.fan.gupao.pattern.strategy.promotion;

/**
 * @Description:优惠卷
 * @Author: 樊高风
 * @Date: 17:46 2020/3/4
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠卷，课程的价格直接减优惠卷面值抵扣");
    }
}
