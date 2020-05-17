package com.fan.gupao.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.fan.gupao.demo.persistence")
@SpringBootApplication
public class SpringBootThreadDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThreadDemoApplication.class, args);
    }

}
