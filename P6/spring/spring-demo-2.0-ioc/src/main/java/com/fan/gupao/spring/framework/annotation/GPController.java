package com.fan.gupao.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:33 2020/3/26
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPController {
    String value() default "";
}
