package com.fan.gupao.mybatis.v2.annotation;

import java.lang.annotation.*;

/**
 * @Description: 注解方法，配置SQL语句
 * @Author: 樊高风
 * @Date: 9:43 2020/5/15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    String value();
}
