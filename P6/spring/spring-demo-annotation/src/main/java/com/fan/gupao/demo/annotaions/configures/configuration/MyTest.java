package com.fan.gupao.demo.annotaions.configures.configuration;

import com.fan.gupao.project.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:36 2020/4/14
 */
public class MyTest {

    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);

        Object person = app.getBean("person");
        System.out.println(person);

        String[] beanNames = app.getBeanNamesForType(Person.class);
        System.out.println(Arrays.toString(beanNames));
    }

}
