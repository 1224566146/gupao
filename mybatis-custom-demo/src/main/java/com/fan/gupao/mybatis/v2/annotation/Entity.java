package com.fan.gupao.mybatis.v2.annotation;

import java.lang.annotation.*;

/**
 * @Description: 用于注解接口，以映射返回的实体类
 * @Author: 樊高风
 * @Date: 9:40 2020/5/15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {
    Class<?> value();
}
