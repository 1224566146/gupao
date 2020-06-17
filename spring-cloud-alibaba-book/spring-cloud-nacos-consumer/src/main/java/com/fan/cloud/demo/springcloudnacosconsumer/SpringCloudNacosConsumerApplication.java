package com.fan.cloud.demo.springcloudnacosconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.fan.cloud.demo.controller")
public class SpringCloudNacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosConsumerApplication.class, args);
    }

}
