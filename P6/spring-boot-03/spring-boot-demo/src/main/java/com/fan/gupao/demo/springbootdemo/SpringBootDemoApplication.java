package com.fan.gupao.demo.springbootdemo;

import com.fan.gupao.autoconfiguration.demo.GupaoEduCore;
import com.fan.gupao.demo.demo04.EnableConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableConfiguration
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        System.out.println(context.getBean(GupaoEduCore.class));
    }

}
