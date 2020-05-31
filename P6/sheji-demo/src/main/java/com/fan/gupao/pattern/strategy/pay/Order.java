package com.fan.gupao.pattern.strategy.pay;

import com.fan.gupao.pattern.strategy.pay.payport.PayStategy;
import com.fan.gupao.pattern.strategy.pay.payport.Payment;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:02 2020/3/4
 */
public class Order {

    private String uid;

    private String orderId;

    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    //完美的解决了switch的过程，不需要在代码逻辑中写switch
    //更不需要写 if  else if
    public MsgResult pay(){
        return pay(PayStategy.DEFAULT_PAY);
    }

    public MsgResult pay(String payKey){
        Payment payment = PayStategy.get(payKey);
        System.out.println("欢迎使用:"+payment.getName());
        System.out.println("本次交易金额:"+amount);
        return payment.pay(uid, amount);
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
