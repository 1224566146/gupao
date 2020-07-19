package com.fan.gupao.demo.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 樊高风
 * @date 2020/7/19
 */
@RestController
public class HystrixController {


    @Auto
    RestTemplate restTemplate;


    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    },fallbackMethod = "fallback")
    @GetMapping("/hystrix/order/{num}")
    public String queryOrder(@PathVariable("num") int num){
        if(num %2 ==0){
            return "正常访问";
        }
        // restTemplate默认有一个请求超时时间
        return restTemplate.getForObject("http://localhost:8082/orders", String.class);
    }


    @HystrixCommand(fallbackMethod = "timeoutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping("/hystrix/timeout")
    public String queryOrderTimeout(){
        return restTemplate.getForObject("http://localhost:8082/orders", String.class);
    }


    public String timeoutFallback(){
        return "连接超时";
    }


    public String fallback(int num){
        return "系统繁忙";
    }
}
