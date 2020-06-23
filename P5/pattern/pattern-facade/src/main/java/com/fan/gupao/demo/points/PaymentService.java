package com.fan.gupao.demo.points;

/**
 * @author 樊高风
 * @date 2020/6/23 16:00
 */
public class PaymentService {

    public boolean pay(GiftInfo gitInfo){
        System.out.println("扣减:"+gitInfo.getName()+"积分成功");
        return true;
    }
}
