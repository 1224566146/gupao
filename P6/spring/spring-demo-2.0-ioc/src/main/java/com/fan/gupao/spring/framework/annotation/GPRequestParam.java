package com.fan.gupao.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:36 2020/3/26
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestParam {
    String value() default "";
}
