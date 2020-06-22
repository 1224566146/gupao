package com.fan.gupao.demo06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 樊高风
 * @date 2020/6/22 13:41
 */
public class Task02Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(TaskConfiguration.class);

    }
}
