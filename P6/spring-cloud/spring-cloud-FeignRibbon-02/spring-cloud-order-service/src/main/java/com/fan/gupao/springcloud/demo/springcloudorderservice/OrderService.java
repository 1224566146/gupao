package com.fan.gupao.springcloud.demo.springcloudorderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/7/2
 */
@RestController
public class OrderService {

    @Value("${server.port}")
    private int port;


    @GetMapping("/orders")
    public String getAllOrder(){
        System.out.println("port:"+port);
        return "Return All Order";
    }
}
