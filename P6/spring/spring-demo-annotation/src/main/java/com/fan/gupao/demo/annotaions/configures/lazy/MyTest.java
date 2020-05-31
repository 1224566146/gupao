package com.fan.gupao.demo.annotaions.configures.lazy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:43 2020/4/14
 */
public class MyTest {


    @Test
    public void test(){

        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("IOC容器创建完成");
        app.getBean("person");


    }

}
