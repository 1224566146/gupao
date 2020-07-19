package com.fan.gupao.demo.springcloudhystrixdashboard9092;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class SpringCloudHystrixDashboard9092Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixDashboard9092Application.class, args);
    }

}
