package com.fan.gupao.demo.springclouddubbosampleconsumer;

import com.fan.gupao.demo.ISayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringCloudDubboSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboSampleConsumerApplication.class, args);
    }


    @Reference
    private ISayHelloService sayHelloService;


    @GetMapping("/test")
    public String test(){
        String hello = sayHelloService.sayHello("樊高风");
        return hello;
    }

}
