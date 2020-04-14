package com.fan.gupao.demo.annotaions.configures.conditional;

import com.fan.gupao.project.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:35 2020/4/14
 */
@Configuration
public class MyConfig {

    @Conditional(WinCondition.class)
    @Bean
    public Person tom() {
        System.out.println("将tom添加到容器中");
        return new Person("Tom", 18);
    }

    @Conditional(WinCondition.class)
    @Bean
    public Person mic() {
        System.out.println("将mic添加到容器中");
        return new Person("mic", 19);
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public Person jams() {
        System.out.println("将jams添加到容器中");
        return new Person("jams", 19);
    }

}
