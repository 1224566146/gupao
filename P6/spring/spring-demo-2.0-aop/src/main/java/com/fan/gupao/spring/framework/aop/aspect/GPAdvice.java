package com.fan.gupao.spring.framework.aop.aspect;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:55 2020/4/13
 */
@Data
public class GPAdvice {

    private Object aspect;

    private Method adviceMthod;

    private String throwName;

    public GPAdvice(Object aspect, Method adviceMthod) {
        this.aspect = aspect;
        this.adviceMthod = adviceMthod;
    }
}
