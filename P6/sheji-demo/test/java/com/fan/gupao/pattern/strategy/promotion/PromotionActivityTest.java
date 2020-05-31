package com.fan.gupao.pattern.strategy.promotion;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:50 2020/3/4
 */
public class PromotionActivityTest {

//    public static void main(String[] args) {
//
//        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
//        PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());
//
//        activity618.execute();
//        activity1111.execute();
//
//
//    }

//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = null;
//        String promotionKey = "COUPON";
//        if(StringUtils.equals(promotionKey, "COUPON")){
//            promotionActivity = new PromotionActivity(new CouponStrategy());
//        }else if(StringUtils.equals(promotionKey, "CASHBACK")){
//            promotionActivity = new PromotionActivity(new CashbackStrategy());
//        }//...............
//
//        promotionActivity.execute();
//    }


    public static void main(String[] args) {

        String promotionKey = "COUPONs";

        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();

    }
}
