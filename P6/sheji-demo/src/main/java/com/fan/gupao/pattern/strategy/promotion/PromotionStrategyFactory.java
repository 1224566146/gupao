package com.fan.gupao.pattern.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 促销策略工厂
 * @Author: 樊高风
 * @Date: 17:56 2020/3/4
 */
public class PromotionStrategyFactory {

    private static Map<String,PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK,new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY, new GroupbuyStrategy());
    }

    private static  final  PromotionStrategy NON_PROMOTION = new EmptyStrategy();

    private PromotionStrategyFactory(){

    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }


    private interface PromotionKey{

        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";

    }

}
