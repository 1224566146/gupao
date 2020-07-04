package com.fan.gupao.delegate.demo.mvc;

import com.fan.gupao.delegate.demo.mvc.controller.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 樊高风
 * @date 2020/7/4
 */
public class DispatcherServlet extends HttpServlet {

    private Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getRequestURI();
        Method method = handlerMapping.get(url);

    }

    @Override
    public void init() throws ServletException {
        try {
            handlerMapping.put("/web/getMemberById.json", MemberController.class.getMethod("getMemberById", String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
