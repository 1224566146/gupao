package com.fan.gupao.demo.springclouddubbosampleconsumer;

import com.fan.gupao.demo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/9/30
 */
@RestController
public class SentinelController {


    @DubboReference(mock = "com.fan.gupao.demo.springclouddubbosampleconsumer.SayHelloServiceMock")
    private ISayHelloService sayHelloService;


    @GetMapping("/say")
    public String say() {
        String hello = sayHelloService.sayHello("樊高风");
        return hello;
    }

    @GetMapping("/exception")
    public String exception() {
        return sayHelloService.exceptionTest();
    }
}
