package com.fan.gupao.pattern.proxy.dbroute;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:41 2020/3/2
 */
public class OrderService implements  IOrderService {

    private OrderDao orderDao;

    public OrderService(){
        //如果使用Spring应该是自动注入的
        //我们为了方便，在构造方法中将orderDao直接初始化了
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用OrderDao创建订单");
        return orderDao.inser(order);
    }
}
