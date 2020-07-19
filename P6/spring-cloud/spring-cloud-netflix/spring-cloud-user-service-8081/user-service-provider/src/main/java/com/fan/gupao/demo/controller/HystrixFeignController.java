package com.fan.gupao.demo.controller;

import com.fan.gupao.demo.clients.OrderServiceFeignClient;
import com.fan.gupao.demo.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/7/19
 */
@RestController
public class HystrixFeignController {

    @Autowired
    OrderServiceFeignClient orderServiceFeignClient;


    @GetMapping("/hystrix/feign/order")
    public String queryOrder(){
        return orderServiceFeignClient.orders();
    }


    @PostMapping("/hystrix/feign/order")
    public String insertOrder(){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId("GP0001");
        return orderServiceFeignClient.insert(orderDto) > 0? "SUCCESS":"FAILED";
    }
}
