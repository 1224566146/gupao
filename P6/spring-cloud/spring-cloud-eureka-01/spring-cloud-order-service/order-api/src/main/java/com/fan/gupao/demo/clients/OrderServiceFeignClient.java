package com.fan.gupao.demo.clients;

import com.fan.gupao.demo.OrderService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
@FeignClient("order-service")
public interface OrderServiceFeignClient extends OrderService {
}
