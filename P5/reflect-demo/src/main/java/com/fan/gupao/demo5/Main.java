package com.fan.gupao.demo5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:52 2020/5/26
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");


        A a =(A) context.getBean("a");
        B b =(B) context.getBean("b");
        C cc =(C) context.getBean("c");
    }
}
