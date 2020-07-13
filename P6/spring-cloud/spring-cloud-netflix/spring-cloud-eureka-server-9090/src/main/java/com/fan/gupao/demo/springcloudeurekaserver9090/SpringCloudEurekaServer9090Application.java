package com.fan.gupao.demo.springcloudeurekaserver9090;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServer9090Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServer9090Application.class, args);
    }

}
