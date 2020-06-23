package com.fan.gupao.demo.points;

/**
 * @author 樊高风
 * @date 2020/6/23 16:03
 */
public class QualifyService {

    public boolean isAvailable(GiftInfo giftInfo){
        System.out.println("校验:"+giftInfo.getName()+"积分通过，库存通过");
        return true;
    }
}
