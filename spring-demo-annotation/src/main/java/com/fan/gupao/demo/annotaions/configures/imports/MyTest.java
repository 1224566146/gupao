package com.fan.gupao.demo.annotaions.configures.imports;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:08 2020/4/14
 */
public class MyTest {


    @Test
    public void test(){

        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        //通过FactoryBean注入的值
        System.out.println("===================="+app.getBean("monkey").getClass());
        Object monkey = app.getBean("monkey");
        Object monkey2 = app.getBean("monkey");
        System.out.println("是否单例："+monkey == monkey2);


        //拿到构建Monkey的FactoryBean
        Object bean = app.getBean("&monkey");
        System.out.println(bean);

        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames).replaceAll("\\[|\\]", "").replaceAll(",", "\n"));
    }

}
