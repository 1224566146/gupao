package com.fan.gupao.springmvc.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:34 2020/3/26
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestMapping {
    String value() default "";
}
