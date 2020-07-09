package com.fan.gupao.springcloud.demo.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 樊高风
 * @date 2020/7/2
 */
@Configuration
public class TestConfiguration {

    @Qualifier
    @Bean(value = "testClass1")
    TestClass testClass1(){
        return new TestClass("testClass1");
    }

    @Qualifier
    @Bean(value = "testClass2")
    TestClass testClass2(){
        return new TestClass("testClass2");
    }
}
