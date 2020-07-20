package com.fan.gupao.demo.controller;

import com.fan.gupao.demo.userserviceprovider.hystrix.GpHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 樊高风
 * @date 2020/7/20
 */
@RestController
public class GpHystrixController {

    @Autowired
    RestTemplate restTemplate;


    @GpHystrixCommand(fallback = "fallback",timeout = 3000)
    @GetMapping("/hystrix/test")
    public String test(){
        return restTemplate.getForObject("http://localhost:8082/orders", String.class);
    }


    public String fallback(){
        return "请求被降级";
    }
}
