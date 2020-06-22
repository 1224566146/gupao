package com.fan.gupao.demo03;

import com.fan.gupao.demo04.ImportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 樊高风
 * @date 2020/6/22 11:17
 */
public class Demo04Main {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(SpringConfiguration.class);

        System.out.println(applicationContext.getBean(Demo04Service.class));
        System.out.println(applicationContext.getBean(Demo03Service.class));
        System.out.println(applicationContext.getBean(ImportService.class));
        System.out.println(applicationContext.getBean(Demo04Service.class).getDemo03Service());

    }
}
