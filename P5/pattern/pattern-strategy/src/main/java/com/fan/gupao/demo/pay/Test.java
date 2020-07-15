package com.fan.gupao.demo.pay;

import com.fan.gupao.demo.pay.payport.PayStrategy;

/**
 * @author 樊高风
 * @date 2020/7/15
 */
public class Test {

    public static void main(String[] args) {

        Order order = new Order("1", "20200715123456", 324.5);
        System.out.println(order.pay(PayStrategy.ALI_PAY));


    }
}
