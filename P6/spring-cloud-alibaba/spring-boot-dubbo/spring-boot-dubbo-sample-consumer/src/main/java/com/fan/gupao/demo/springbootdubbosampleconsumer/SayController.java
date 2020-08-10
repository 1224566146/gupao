package com.fan.gupao.demo.springbootdubbosampleconsumer;

import com.fan.gupao.demo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/10
 */
@RestController
public class SayController {


    @DubboReference(registry = {"hunan"},
        protocol = "dubbo",
        loadbalance = "consistenthash",
        mock = "com.fan.gupao.demo.springbootdubbosampleconsumer.MockSayHelloService",
        timeout = 500,
        cluster = "failfast",check = false,
        retries = 5)
    ISayHelloService sayHelloService;


    @GetMapping("/say")
    public String say(){
        return sayHelloService.sayHello("Mic");
    }

}
