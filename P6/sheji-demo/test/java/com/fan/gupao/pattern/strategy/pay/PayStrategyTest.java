package com.fan.gupao.pattern.strategy.pay;

import com.fan.gupao.pattern.strategy.pay.payport.PayStategy;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:26 2020/3/4
 */
public class PayStrategyTest {
    public static void main(String[] args) {


        //省略把商品加到购物车，再从购物车下单
        //直接从点单开始
        Order order = new Order("1", "23423432", 300);

        //开始支付，选择微信支付、支付宝、银联卡、京东白条、财付通
        //每个渠道它支付的具体算法是不一样的
        //基本算法固定的

        //这个值是在支付的时候才决定用哪个值
        System.out.println(order.pay(PayStategy.JD_PAY));

    }
}
