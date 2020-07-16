package com.fan.gupao.demo.profiledemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 樊高风
 * @date 2020/7/16
 */
public class ProfileMain {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfiguration.class);
        context.refresh();

        System.out.println(context.getBean(ProfileService.class));


    }
}
