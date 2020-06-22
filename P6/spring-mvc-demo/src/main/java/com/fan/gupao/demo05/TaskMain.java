package com.fan.gupao.demo05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author 樊高风
 * @date 2020/6/22 13:37
 */
public class TaskMain {

    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

    }
}
