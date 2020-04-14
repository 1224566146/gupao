package com.fan.gupao.demo.annotaions.injections.value;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:11 2020/4/14
 */
public class MyTest {



    @Test
    public void test(){

        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);

        System.out.println(app.getBean("bird"));

        String[] beanDefinitionNames = app.getBeanDefinitionNames();

        System.out.println(Arrays.toString(beanDefinitionNames).replaceAll("\\[|\\]", "")
                .replaceAll(",", "\n"));


    }

}
