package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/18 13:31
 */
@GpRemoteService
public class OrderServiceImpl implements IOrderService {
    @Override
    public String queryOrderList() {
        return "execute queryOrdeerList Method";
    }

    @Override
    public String orderById(String id) {
        return "execute orderById Method";
    }
}
