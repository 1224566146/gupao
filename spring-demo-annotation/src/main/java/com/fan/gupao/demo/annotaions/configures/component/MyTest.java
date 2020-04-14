package com.fan.gupao.demo.annotaions.configures.component;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:07 2020/4/14
 */
public class MyTest {


    @Test
    public static void main(String[] args) {

        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);

        String[] beanDefinitionNames = app.getBeanDefinitionNames();

        System.out.println(Arrays.toString(beanDefinitionNames).replaceAll("\\[|\\]", "")
        .replaceAll(",", "\n"));


    }

}
