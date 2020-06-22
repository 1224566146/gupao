package com.fan.gupao.demo02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author 樊高风
 * @date 2020/6/22 10:38
 */
public class Demo02Main {

    public static void main(String[] args) {


        ApplicationContext context =
                new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

        System.out.println(context.getBean(Demo02Service.class));

    }
}
