package com.fan.gupao.demo.annotaions.configures.scope;

import com.fan.gupao.project.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:35 2020/4/14
 */
@Configuration
public class MyConfig {


    // prototype 多例
    // singleton 单例
    // request 主要应用于web模块，同一次请求只创建一个实例
    // session 主要应用于web模块，同一个session只创建一个实例
    @Scope("singleton")
    @Bean
    public Person person(){
        // IOC实例化对象的时候，并不是简单的调用我们定义的方法
        return new Person("Tom",18);
    }

}
