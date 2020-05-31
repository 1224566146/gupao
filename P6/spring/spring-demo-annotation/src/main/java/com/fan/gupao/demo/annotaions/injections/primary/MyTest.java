package com.fan.gupao.demo.annotaions.injections.primary;

import com.fan.gupao.project.service.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:22 2020/4/14
 */
public class MyTest {

    @Test
    public void test(){

        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);

        MyService bean = app.getBean(MyService.class);

        bean.print();
    }
}
