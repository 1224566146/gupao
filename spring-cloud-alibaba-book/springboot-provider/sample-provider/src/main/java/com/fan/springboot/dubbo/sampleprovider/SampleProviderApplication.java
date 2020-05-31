package com.fan.springboot.dubbo.sampleprovider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan(basePackages = "com.fan.springboot.dubbo.demo")
@SpringBootApplication
public class SampleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleProviderApplication.class, args);
    }

}
