package com.fan.gupao.demo.demo02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public GpRedisTemplate gpRedisTemplate(){
        return new GpRedisTemplate();
    }
}
