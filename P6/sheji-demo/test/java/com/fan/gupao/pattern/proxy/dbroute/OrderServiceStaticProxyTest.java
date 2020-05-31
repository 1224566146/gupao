package com.fan.gupao.pattern.proxy.dbroute;

import com.fan.gupao.pattern.proxy.dbroute.proxy.OrderServiceStaticProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:00 2020/3/2
 */
public class OrderServiceStaticProxyTest {

    public static void main(String[] args) {

        Order order = new Order();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse("2017/02/01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        order.setCreateTime(date.getTime());

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy(new OrderService());
        orderServiceStaticProxy.createOrder(order);


    }
}
