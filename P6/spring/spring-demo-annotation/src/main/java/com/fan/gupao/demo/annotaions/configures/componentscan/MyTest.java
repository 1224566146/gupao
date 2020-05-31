package com.fan.gupao.demo.annotaions.configures.componentscan;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:42 2020/4/14
 */
public class MyTest {


    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);

        String[] names = app.getBeanDefinitionNames();

        System.out.println(Arrays.toString(names).replaceAll("\\[|\\]", "")
        .replaceAll(",", "\n"));
    }
}
