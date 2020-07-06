package com.fan.gupao.springcloud.demo.demo01;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
@FeignClient("spring-cloud-order-service")
public interface OrderServiceFeignClient {


    @GetMapping("/orders")
    String getAllOrder();
}
