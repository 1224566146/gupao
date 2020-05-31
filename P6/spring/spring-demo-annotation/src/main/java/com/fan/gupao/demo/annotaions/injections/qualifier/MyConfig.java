package com.fan.gupao.demo.annotaions.injections.qualifier;

import com.fan.gupao.project.dao.MyDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:52 2020/4/14
 */
@Configuration
@ComponentScan({
        "com.fan.gupao.project.controller",
        "com.fan.gupao.project.service",
        "com.fan.gupao.project.dao"
})
public class MyConfig {

    @Bean("dao")
    public MyDao dao(){
        MyDao dao = new MyDao();
        dao.setFlag("2");
        return dao;
    }

}
