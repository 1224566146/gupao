package com.fan.gupao.pattern.proxy.dbroute;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:40 2020/3/2
 */
public class OrderDao {

    public int inser(Order order){
        System.out.println("OrderDao创建Order成功");
        return 1;
    }
}
