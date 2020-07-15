package com.fan.gupao.demo.promotion;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class PromotionActivity {

    private IPromotionStrategy strategy;

    public PromotionActivity(IPromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.doPromotion();
    }
}
