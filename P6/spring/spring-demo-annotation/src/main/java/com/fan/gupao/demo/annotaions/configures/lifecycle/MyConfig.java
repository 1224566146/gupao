package com.fan.gupao.demo.annotaions.configures.lifecycle;

import com.fan.gupao.project.entity.Car;
import org.springframework.context.annotation.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:53 2020/4/14
 */
@Configuration
@ComponentScans({
        @ComponentScan("com.fan.gupao.project"),
        @ComponentScan("com.fan.gupao.demo.annotaions.configures.lifecycle")
        })
public class MyConfig {


    @Lazy
    @Bean(initMethod = "addOil",destroyMethod = "close")
    public Car car(){
        return new Car();
    }


    // 3种方式
    // 1、添加initMehtod 和 destoryMethod
    // 2、实现InitializingBean 和 DisposableBean接口
    // 3、使用@PostConstruct和@PreDestory注解


}
