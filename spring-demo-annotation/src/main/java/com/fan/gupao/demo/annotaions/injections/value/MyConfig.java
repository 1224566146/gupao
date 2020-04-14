package com.fan.gupao.demo.annotaions.injections.value;

import com.fan.gupao.project.entity.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:10 2020/4/14
 */
@Configuration
@PropertySource(value = {
        "classpath:values.properties"
})
public class MyConfig {

    @Bean
    public Bird bird(){
        return new Bird();
    }

}
