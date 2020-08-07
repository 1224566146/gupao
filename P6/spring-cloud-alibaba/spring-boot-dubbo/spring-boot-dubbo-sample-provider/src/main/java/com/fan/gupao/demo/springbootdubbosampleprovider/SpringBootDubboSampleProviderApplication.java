package com.fan.gupao.demo.springbootdubbosampleprovider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan(basePackages = "com.fan.gupao.demo.springbootdubbosampleprovider.services")
@SpringBootApplication
public class SpringBootDubboSampleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboSampleProviderApplication.class, args);
    }

}
