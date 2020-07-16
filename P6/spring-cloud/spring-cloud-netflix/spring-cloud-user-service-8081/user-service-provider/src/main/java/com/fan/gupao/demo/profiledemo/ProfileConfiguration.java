package com.fan.gupao.demo.profiledemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author 樊高风
 * @date 2020/7/16
 */
@Configuration
public class ProfileConfiguration {

    @Profile("dev")
    @Bean
    public ProfileService profileServiceDec(){
        return new ProfileService("dev");
    }


    @Profile("prd")
    @Bean
    public ProfileService profileServicePrd(){
        return new ProfileService("prd");
    }

}
