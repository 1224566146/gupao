package com.fan.gupao.demo.springbootdubbosampleconsumer;

import com.fan.gupao.demo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SpringBootDubboSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboSampleConsumerApplication.class, args);
    }

    @DubboReference(registry = {"shanghai","hunan"},version = "2.0")
    ISayHelloService sayHelloService;


    @GetMapping("/test")
    public String test(){
        return sayHelloService.sayHello("樊高风");
    }

}
