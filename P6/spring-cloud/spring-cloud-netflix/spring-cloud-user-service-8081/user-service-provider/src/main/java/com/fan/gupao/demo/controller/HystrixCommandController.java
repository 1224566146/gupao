package com.fan.gupao.demo.controller;

import com.fan.gupao.demo.userserviceprovider.service.HystrixCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 樊高风
 * @date 2020/7/20
 */
@RestController
public class HystrixCommandController {


    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/hystrix/command/{num}")
    public String hystrixCommand(@PathVariable("num")int num){
        HystrixCommandService hystrixCommandService = new HystrixCommandService(num, restTemplate);
        // 执行
        return hystrixCommandService.execute();
    }
}
