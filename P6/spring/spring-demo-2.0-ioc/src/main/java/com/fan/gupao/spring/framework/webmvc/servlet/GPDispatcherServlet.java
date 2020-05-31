package com.fan.gupao.spring.framework.webmvc.servlet;

import com.fan.gupao.spring.framework.context.GPApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 委派模式
 *              职责:负责任务调度，请求分发
 * @Author: 樊高风
 * @Date: 18:27 2020/4/3
 */
public class GPDispatcherServlet extends HttpServlet {

    private GPApplicationContext applicationContext;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        applicationContext = new GPApplicationContext(config.getInitParameter("contextConfigLocation"));

    }
}
