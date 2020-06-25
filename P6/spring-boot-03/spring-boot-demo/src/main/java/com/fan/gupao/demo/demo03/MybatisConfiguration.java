package com.fan.gupao.demo.demo03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
@Configuration
public class MybatisConfiguration {

    @Bean
    public GpSqlSessionFactory gpSqlSessionFactory(){
        return new GpSqlSessionFactory();
    }
}
