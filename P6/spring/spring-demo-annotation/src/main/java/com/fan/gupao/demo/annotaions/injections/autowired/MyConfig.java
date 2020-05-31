package com.fan.gupao.demo.annotaions.injections.autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:21 2020/4/14
 */
@Configuration
@ComponentScan({
        "com.fan.gupao.project.controller",
        "com.fan.gupao.project.service",
        "com.fan.gupao.project.dao"
})
public class MyConfig {
}
