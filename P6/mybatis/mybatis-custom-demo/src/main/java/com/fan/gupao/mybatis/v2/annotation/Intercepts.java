package com.fan.gupao.mybatis.v2.annotation;

import java.lang.annotation.*;

/**
 * @Description: 用于注解拦截器，指定拦截的方法
 * @Author: 樊高风
 * @Date: 9:42 2020/5/15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Intercepts {
    String value();
}
