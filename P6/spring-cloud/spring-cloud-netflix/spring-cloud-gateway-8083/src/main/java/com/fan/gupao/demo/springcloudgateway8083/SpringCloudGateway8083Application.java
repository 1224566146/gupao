package com.fan.gupao.demo.springcloudgateway8083;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.fan.gupao.demo.clients")
@SpringBootApplication
public class SpringCloudGateway8083Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGateway8083Application.class, args);
    }

}
