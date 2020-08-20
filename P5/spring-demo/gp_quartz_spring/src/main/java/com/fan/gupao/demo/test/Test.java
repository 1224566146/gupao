package com.fan.gupao.demo.test;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
public class Test {

    public static void main(String[] args) throws SchedulerException {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-quartz.xml");
        Scheduler scheduler = applicationContext.getBean("scheduler", Scheduler.class);
        scheduler.start();
    }
}
