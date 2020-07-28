package com.fan.gupao.demo.orderserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableFeignClients(basePackages = "com.fan.gupao.demo.clients")
@SpringBootApplication
public class OrderServiceProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderServiceProviderApplication.class, args);
    }

}
