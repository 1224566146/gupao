package com.fan.gupao.demo.sourceloader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/7/16
 */
@Configuration
public class GpDefineBootStrapConfiguration {

    @Bean
    public JsonProperySourceLocator jsonProperySourceLocator(){
        return new JsonProperySourceLocator();
    }
}
