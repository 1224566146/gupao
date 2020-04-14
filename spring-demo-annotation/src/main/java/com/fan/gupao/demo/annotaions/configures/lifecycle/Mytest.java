package com.fan.gupao.demo.annotaions.configures.lifecycle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:57 2020/4/14
 */
public class Mytest {


    @Test
    public void test(){

        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("IOC容器创建完成");

//        System.out.println(app.getBean("car"));

        System.out.println(app.getBean("train"));

        System.out.println(app.getBean("airPlane"));
        app.close();

    }
}
