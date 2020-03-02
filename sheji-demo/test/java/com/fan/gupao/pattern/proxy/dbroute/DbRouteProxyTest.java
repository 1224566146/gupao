package com.fan.gupao.pattern.proxy.dbroute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:45 2020/3/2
 */
public class DbRouteProxyTest {

    public static void main(String[] args) {

        try {

            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date =sdf.parse("2017/02/01");

            order.setCreateTime(date.getTime());

            IOrderService iOrderService = new OrderService();
            iOrderService.createOrder(order);


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
