package com.fan.gupao.demo.annotaions.injections.autowired;

import com.fan.gupao.project.dao.MyDao;
import com.fan.gupao.project.service.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:22 2020/4/14
 */
public class MyTest {


    @Test
    public void test(){

        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);

        Object myController = app.getBean("myController");

        System.out.println(myController);

        MyService bean = app.getBean(MyService.class);
        bean.print();

        MyDao bean1 = app.getBean(MyDao.class);
        System.out.println(bean1);

    }
}
