package com.fan.gupao.springmvc.demo.service;


import com.fan.gupao.springmvc.mvcframework.annotation.GPService;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:40 2020/3/26
 */
@GPService
public class DemoService implements IDemoService {
    @Override
    public String get(String name) {
        return "My Name is"+name;
    }
}
