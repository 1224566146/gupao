package com.fan.gupao.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:29 2020/3/26
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPAutowired {
    String  value() default "";
}
