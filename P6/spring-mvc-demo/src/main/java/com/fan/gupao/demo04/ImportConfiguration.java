package com.fan.gupao.demo04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/6/22 13:33
 */
@Configuration
public class ImportConfiguration {


    @Bean
    public ImportService importService(){
        return new ImportService();
    }
}
