package com.fan.gupao.demo.springclouddubbosampleconsumer;

import com.fan.gupao.demo.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/27
 */
@RefreshScope
@RestController
public class TestController {

    @Reference
    IHelloService helloService;

    @Value("${info:hello Nacos}")
    private String info;

    @GetMapping("/get")
    public String get(){
        return info;
    }

    @GetMapping("/say")
    public String say(){
        return helloService.sayHello();
    }

}
