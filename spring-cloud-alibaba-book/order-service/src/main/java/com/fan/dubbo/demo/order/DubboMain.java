package com.fan.dubbo.demo.order;

import com.fan.dubbo.demo.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:03 2020/5/29
 */
public class DubboMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/consumer.xml");
        IUserService iUserService = (IUserService) context.getBean("userService");
        System.out.println(iUserService.getNameById("10001"));

    }
}
