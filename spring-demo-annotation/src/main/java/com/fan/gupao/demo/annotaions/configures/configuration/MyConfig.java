package com.fan.gupao.demo.annotaions.configures.configuration;

import com.fan.gupao.project.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:35 2020/4/14
 */
@Configuration
public class MyConfig {

    @Bean
    public Person person(){
        return new Person("Tom",18);
    }

    @Bean
    public Person person1(){
        return new Person("fgf",19);
    }

}
