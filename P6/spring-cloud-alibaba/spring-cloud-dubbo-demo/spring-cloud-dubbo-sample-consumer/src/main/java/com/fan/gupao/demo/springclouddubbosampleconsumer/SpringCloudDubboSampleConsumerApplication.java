package com.fan.gupao.demo.springclouddubbosampleconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudDubboSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboSampleConsumerApplication.class, args);
    }

}
