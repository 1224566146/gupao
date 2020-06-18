package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/18 9:43
 */
public class OrderServiceImpl implements IOrderService {
    @Override
    public String queryOrderList() {
        return "execute queryOrderList Method";
    }

    @Override
    public String orderById(String id) {
        return "execute orderById Method";
    }
}
