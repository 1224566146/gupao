package com.fan.gupao.spring.framework.webmvc.servlet;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:51 2020/4/13
 */
@Data
public class GPHandlerMapping {

    private Pattern pattern;

    private Method method;

    private Object controller;

    public GPHandlerMapping(Pattern pattern, Object controller, Method method) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;
    }
}
