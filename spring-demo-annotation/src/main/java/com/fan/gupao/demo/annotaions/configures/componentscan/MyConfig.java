package com.fan.gupao.demo.annotaions.configures.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:41 2020/4/14
 */
@Configuration
@ComponentScan(value = "com.fan.gupao.project"
//        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})},    //扫描哪个类型注解
//        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,value = {GPTypeFilter.class})}     //使用自定义过滤扫描
//        includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {MyController.class})}   //扫描某个类
//        useDefaultFilters = false     //是否使用默认扫描策略

        )
public class MyConfig {
}
