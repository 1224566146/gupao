package com.fan.dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:12 2020/5/29
 */
public class DubboMain {

    public static void main(String[] args) throws IOException {

        // 第一种方式
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("classpath*:/META-INF/spring/user-provider.xml");
        context.start();
        System.in.read();  // 阻塞Main线程

        // 第二种方式
//        Main.main(args);


    }
}
