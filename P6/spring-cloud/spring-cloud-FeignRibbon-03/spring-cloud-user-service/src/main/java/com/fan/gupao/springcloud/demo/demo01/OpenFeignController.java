package com.fan.gupao.springcloud.demo.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
@RestController
public class OpenFeignController {


    @Autowired
    OrderServiceFeignClient orderServiceFeignClient;

    @GetMapping("/test")
    public String test(){
        return orderServiceFeignClient.getAllOrder();
    }
}
