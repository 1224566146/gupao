package com.fan.gupao.demo.annotaions.configures.lazy;

import com.fan.gupao.project.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:41 2020/4/14
 */
@Configuration
public class MyConfig {



    //懒加载只针对单例Bean起作用
    //默认容器启动时不创建对象，调用对象的功能才创建
    @Lazy
    @Bean
    public Person person(){
        System.out.println("将对象添加到IOC容器");
        return new Person("Tom",18);
    }

}
