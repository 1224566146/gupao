package com.fan.gupao.springmvc.demo.mvc.action;

import com.fan.gupao.springmvc.demo.service.IDemoService;
import com.fan.gupao.springmvc.mvcframework.annotation.GPAutowired;
import com.fan.gupao.springmvc.mvcframework.annotation.GPController;
import com.fan.gupao.springmvc.mvcframework.annotation.GPRequestMapping;
import com.fan.gupao.springmvc.mvcframework.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:37 2020/3/26
 */
@GPController
@GPRequestMapping("/demo")
public class DemoAction {

    @GPAutowired
    private IDemoService demoService;


    @GPRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response, @GPRequestParam("name") String name) {

        String result = demoService.get(name);
        try {

            response.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GPRequestMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response, @GPRequestParam("a") Integer a, @GPRequestParam("b") Integer b) {

        try {

            response.getWriter().write(a + "+" + b + "=" + (a + b));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GPRequestMapping("remove")
    public void remove(HttpServletRequest request, HttpServletResponse response, @GPRequestParam("id") String id) {

    }

}
