package com.fan.gupao.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ILoginService loginService = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/application.xml");
        loginService = context.getBean(ILoginService.class);
        System.out.println(loginService.login("admin", "admin"));
    }
}
