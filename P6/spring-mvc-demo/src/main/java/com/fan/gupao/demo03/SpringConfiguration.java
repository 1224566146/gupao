package com.fan.gupao.demo03;

import com.fan.gupao.demo04.ImportConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author 樊高风
 * @date 2020/6/22 11:14
 */
@ComponentScan("com.fan.gupao.demo03")
@Configuration // <applicationContext.xml>
@Import(ImportConfiguration.class)
public class SpringConfiguration {


    @Bean
    public Demo04Service demo04Service(Demo03Service demo03Service){
        Demo04Service demo04Service = new Demo04Service();
        demo04Service.setDemo03Service(demo03Service);
        return demo04Service;
    }

}
