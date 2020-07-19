package com.fan.gupao.demo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 樊高风
 * @date 2020/7/19
 */
@Configuration
public class RestTemplateConfiguration {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }
}
