package com.fan.gupao.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/6/18 13:54
 */
@Configuration
@ComponentScan(value = "com.fan.gupao.demo")
public class Bootstrap {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Bootstrap.class);

    }
}
