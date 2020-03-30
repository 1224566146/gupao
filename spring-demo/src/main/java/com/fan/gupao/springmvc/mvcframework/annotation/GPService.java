package com.fan.gupao.springmvc.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:36 2020/3/26
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPService {
    String value() default "";
}
