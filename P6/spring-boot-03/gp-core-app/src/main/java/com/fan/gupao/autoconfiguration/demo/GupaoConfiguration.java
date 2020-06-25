package com.fan.gupao.autoconfiguration.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisOperations;

/**
 * @author 樊高风
 * @date 2020/6/25
 */
@ConditionalOnClass({RedisOperations.class})
@Configuration
public class GupaoConfiguration {


    @Bean
    public GupaoEduCore gupaoEduCore(){
        return new GupaoEduCore();
    }
}
