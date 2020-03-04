package com.fan.gupao.pattern.delegate.mvc;

import com.fan.gupao.pattern.delegate.mvc.controllers.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:09 2020/3/4
 */
public class DispatcherServlet extends HttpServlet {


    private List<Handler> handlerMapping = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        try {
            Class<?> clazz = MemberController.class;

            handlerMapping.add(new Handler().setController(clazz.newInstance()).setMethod(clazz.getMethod("getMemberById", new Class[]{String.class})).setUrl("/web/getMemberById"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDipatch(req, resp);
        super.service(req, resp);
    }

    private void doDipatch(HttpServletRequest req, HttpServletResponse resp) {

        //1、获取用户请求url
        //如果按照J2EE的标准，每个url对应一个servlet，url由浏览器输入
        String uri = req.getRequestURI();

        //2、servlet拿到url以后，要做权衡（要做判断，要做选择）
        //根据用户请求的url，去找到这个url对应的某一个java类方法

        //3、通过拿到的URL去handlerMapping（我们把它认为是策略常量）
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }


        //4、将具体的任务分发给Method(通过反射去调用其对应的方法)
        Object object = null;
        try {

            object = handler.getMethod().invoke(handler.getController(), req.getParameter("mid"));

            //5、获取到Method执行的结果，通过Response返回出去
            resp.getWriter().write("12323");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void doDipatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String uri = req.getRequestURI();
//
//        String mid = req.getParameter("mid");
//
//        if("getMemberById".equals(uri)){
//            new MemberController().getMemberById(mid);
//        }else if("getOrderId".equals(uri)){
//            new OrderController().getOrderById(mid);
//        }else if("logout".equals(uri)){
//            new SystemController().logout();
//        }else{
//            resp.getWriter().write("404 Not Found!!!");
//        }
//
//    }


    class Handler {
        private Object controller;

        private Method method;

        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}
