package com.fan.gupao.demo.orderserviceprovider.service;

import com.fan.gupao.demo.orderserviceprovider.controller.dto.OrderDto;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
public interface IOrderService {


    /**
     * 功能描述: 下单
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/7/27 16:30
     */
    String createOrder(OrderDto orderDto);
}
