package com.fan.gupao.pattern.proxy.dbroute.proxy;

import com.fan.gupao.pattern.proxy.dbroute.IOrderService;
import com.fan.gupao.pattern.proxy.dbroute.Order;
import com.fan.gupao.pattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:53 2020/3/2
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    private IOrderService iOrderService;

    public OrderServiceStaticProxy(IOrderService iOrderService){
        this.iOrderService = iOrderService;
    }

    @Override
    public int createOrder(Order order) {
        Long createTime = order.getCreateTime();
        Integer dbRouter =Integer.valueOf( sdf.format(new Date(createTime)));
        System.out.println("静态代理类自动分配到【DB"+dbRouter+"】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);

        this.iOrderService.createOrder(order);
        DynamicDataSourceEntity.restore();

        return 0;
    }
}
