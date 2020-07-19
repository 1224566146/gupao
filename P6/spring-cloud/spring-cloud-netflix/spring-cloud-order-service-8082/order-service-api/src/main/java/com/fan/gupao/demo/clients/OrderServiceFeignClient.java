package com.fan.gupao.demo.clients;

import com.fan.gupao.demo.OrderService;
import com.fan.gupao.demo.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@FeignClient(value = "order-service",fallback =OrderServiceFeignClient.OrderServiceFeignClientFallback.class )
public interface OrderServiceFeignClient extends OrderService {


    @Component
    class OrderServiceFeignClientFallback implements OrderServiceFeignClient{

        @Override
        public String orders() {
            return "查询订单失败,请稍后重试";
        }

        @Override
        public int insert(OrderDto dto) {
            System.out.println("insert失败");
            return -1;
        }
    }

}
