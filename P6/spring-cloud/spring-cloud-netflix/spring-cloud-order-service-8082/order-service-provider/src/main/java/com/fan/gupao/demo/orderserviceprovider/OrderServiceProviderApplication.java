package com.fan.gupao.demo.orderserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.fan.gupao.demo")
@SpringBootApplication
public class OrderServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceProviderApplication.class, args);
    }

}
