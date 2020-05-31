package com.fan.gupao.demo.annotaions.configures.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:38 2020/4/14
 */
public class MyTest {


    @Test
    public void test(){


        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        Object bean = app.getBean("person");
        System.out.println(bean);

        Object bean2 = app.getBean("person");
        System.out.println(bean2);


        System.out.println(bean == bean2);

    }
}
