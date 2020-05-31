package com.fan.gupao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:31 2020/5/7
 */
public class ApplicationContextTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(RouterConfig.class);

        Object instance = app.getBean("timerRouter2");
        System.out.println(instance);

    }
}
