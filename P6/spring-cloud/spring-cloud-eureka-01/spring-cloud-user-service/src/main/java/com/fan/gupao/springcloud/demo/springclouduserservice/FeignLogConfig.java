package com.fan.gupao.springcloud.demo.springclouduserservice;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }

}
