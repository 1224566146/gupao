package com.fan.gupao.demo.springbootdemo02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
@Configuration
public class EndpointConfiguration {

    @Bean
    public CustomerMetricsIndicator customerMetricsIndicator(){
        return new CustomerMetricsIndicator();
    }
}
