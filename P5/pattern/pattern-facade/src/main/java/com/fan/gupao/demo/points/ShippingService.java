package com.fan.gupao.demo.points;

/**
 * @author 樊高风
 * @date 2020/6/23 16:04
 */
public class ShippingService {

    public String delivery(GiftInfo giftInfo){
        System.out.println(giftInfo.getName()+"进入物流系统");
        String shippingNo = "666";
        return shippingNo;
    }
}
