package com.fan.cloud.demo.controller;

import com.fan.cloud.nacos.demo.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/6/16 22:19
 */
@RestController
public class HelloController {

    @Reference
    private IHelloService iHelloService;

    @GetMapping("/say")
    public String sayHello(){
        return iHelloService.sayHello("Mic");
    }
}
