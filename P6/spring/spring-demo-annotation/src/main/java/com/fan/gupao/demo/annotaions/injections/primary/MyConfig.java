package com.fan.gupao.demo.annotaions.injections.primary;

import com.fan.gupao.project.dao.MyDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:20 2020/4/14
 */
@Configuration
@ComponentScan({
        "com.fan.gupao.project.controller",
        "com.fan.gupao.project.service",
        "com.fan.gupao.project.dao"
})
public class MyConfig {



    @Primary
    @Bean("myDao")
    public MyDao dao(){
        MyDao dao = new MyDao();
        dao.setFlag("9");
        return dao;
    }

    @Bean("myDao")
    public MyDao myDao(){
        MyDao dao = new MyDao();
        dao.setFlag("3");
        return dao;
    }

}
