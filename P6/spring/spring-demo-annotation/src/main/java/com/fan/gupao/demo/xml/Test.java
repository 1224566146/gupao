package com.fan.gupao.demo.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:32 2020/4/14
 */
public class Test {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        Object person = applicationContext.getBean("person");

        System.out.println(person);

    }
}
