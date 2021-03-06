package com.fan.gupao.springcloud.demo.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 樊高风
 * @date 2020/7/2
 */
@RestController
public class UserController {


    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Autowired
//    LoadBalancerClient loadBalancerClient;


    @GetMapping("/user/{id}")
    public String findById(@PathVariable("id")int id){
        // TODO
        // 调用订单的服务获得订单信息
//        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-order-service");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(),serviceInstance.getPort()+"/orders");
//        return restTemplate.getForObject(url, String.class);
        return restTemplate.getForObject("http://spring-cloud-order-service/orders", String.class);
    }

}
