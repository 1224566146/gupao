package com.fan.gupao.demo.userserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.fan.gupao.demo.controller",
        "com.fan.gupao.demo.sourceloader",
        "com.fan.gupao.demo",
        "com.fan.gupao.demo.clients"
})
@EnableFeignClients(basePackages = "com.fan.gupao.demo.clients")
@SpringBootApplication
public class UserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }

}
