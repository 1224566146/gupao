package com.fan.gupao.pattern.strategy.promotion;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:49 2020/3/4
 */
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        promotionStrategy.doPromotion();
    }

}
