package com.fan.gupao.springcloud.demo.springclouduserservice;

import com.fan.gupao.demo.clients.OrderServiceFeignClient;
import com.fan.gupao.demo.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
@RestController
public class TestController {

     @Autowired
     OrderServiceFeignClient orderServiceFeignClient;

     @GetMapping("/test")
     public String test(){
          return orderServiceFeignClient.orders();
     }

     @PostMapping("/test")
     public String insert(){
          OrderDto orderDto = new OrderDto();
          return orderServiceFeignClient.insert(orderDto)+" ";
     }

}
