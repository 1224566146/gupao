package com.fan.gupao.demo.annotaions.configures.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:04 2020/4/14
 */
@Configuration
@ComponentScan(value = "com.fan.gupao.project",
includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Component.class})},
useDefaultFilters = false)
public class MyConfig {
}
