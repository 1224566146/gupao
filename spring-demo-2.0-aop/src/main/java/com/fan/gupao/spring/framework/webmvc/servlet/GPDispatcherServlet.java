package com.fan.gupao.spring.framework.webmvc.servlet;

import com.fan.gupao.spring.framework.annotation.GPController;
import com.fan.gupao.spring.framework.annotation.GPRequestMapping;
import com.fan.gupao.spring.framework.context.GPApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 委派模式
 * 职责：负责任务调度，请求分发
 * @Author: 樊高风
 * @Date: 14:48 2020/4/13
 */
public class GPDispatcherServlet extends HttpServlet {

    private GPApplicationContext applicationContext;

    private List<GPHandlerMapping> handlerMappings = new ArrayList<>();

    private Map<GPHandlerMapping, GPHandlerAdapter> handlerAdapters = new ConcurrentHashMap<>();

    private List<GPViewResolver> viewResolvers = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 6、委派，根据URL去找到一个对应的Method并通过返回response返回
        try {

            doDispatch(req, resp);
        } catch (Exception e) {

        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //完成了对HandlerMapping的封装
        //完成了对方法返回值的封装ModelAndView


        // 1、通过URL获得一个HandlerMapping
        GPHandlerMapping handlerMapping = getHandler(req);

        if(handlerMapping == null){
            processDispatchResult(req,resp,new GPModelAndView("404"));
            return;
        }

        // 2、根据一个HandlerMapping获得一个HandlerAdapter
        GPHandlerAdapter gpHandlerAdapter = getHandlerAdapter(handlerMapping);

        // 3、解析某一个方法的形参和返回值之后，统一封装为ModelAndView对象
        GPModelAndView mv = gpHandlerAdapter.handler(req, resp, handlerMapping);



        // 就把ModelAndView变成一个ViewResolver
        processDispatchResult(req, resp, mv);

    }

    private GPHandlerAdapter getHandlerAdapter(GPHandlerMapping handlerMapping) {
        if(this.handlerAdapters.isEmpty()){
            return null;
        }
        return this.handlerAdapters.get(handlerMapping);
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, GPModelAndView gpModelAndView) throws Exception {

        if(null == gpModelAndView){
            return;
        }
        if(this.viewResolvers.isEmpty()){
            return;
        }

        for (GPViewResolver viewResolver : this.viewResolvers) {

            GPView view = viewResolver.resolveViewName(gpModelAndView.getViewName());

            //直接往浏览器输出
            view.render(gpModelAndView.getModel(), req, resp);
            return;

        }


    }

    private GPHandlerMapping getHandler(HttpServletRequest req) {


        if(this.handlerMappings.isEmpty()){

            return null;
        }
        String url = req.getRequestURI();

        String contextPath = req.getContextPath();

        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");

        for (GPHandlerMapping handlerMapping : this.handlerMappings) {

            Matcher matcher = handlerMapping.getPattern().matcher(url);

            if(!matcher.matches()){
                continue;
            }

            return handlerMapping;

        }

        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        //初始化Spring核心IOC容器
        applicationContext = new GPApplicationContext(config.getInitParameter("contextConfigLocation"));

        //完成了IOC、DI和MVC部分对接

        //初始化九大组件
        initStrategies(applicationContext);

        System.out.println("GP Spring framework is init");


    }

    private void initStrategies(GPApplicationContext context) {
        //        //多文件上传的组件
//        initMultipartResolver(context);
//        //初始化本地语言环境
//        initLocaleResolver(context);
//        //初始化模板处理器
//        initThemeResolver(context);
        //handlerMapping
        initHandlerMappings(context);
        //初始化参数适配器
        initHandlerAdapters(context);
//        //初始化异常拦截器
//        initHandlerExceptionResolvers(context);
//        //初始化视图预处理器
//        initRequestToViewNameTranslator(context);
        //初始化视图转换器
        initViewResolvers(context);
//        //FlashMap管理器
//        initFlashMapManager(context);
    }

    private void initViewResolvers(GPApplicationContext context) {

        String templateRoot = context.getConfig().getProperty("templateRoot");
        String tempateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File templateRootDir = new File(tempateRootPath);

        for (File file : templateRootDir.listFiles()) {

            this.viewResolvers.add(new GPViewResolver(templateRoot));

        }


    }

    private void initHandlerAdapters(GPApplicationContext context) {

        for (GPHandlerMapping handlerMapping : handlerMappings) {

            this.handlerAdapters.put(handlerMapping, new GPHandlerAdapter());

        }


    }

    private void initHandlerMappings(GPApplicationContext context) {

        if(context.getBeanDefinitionCount() == 0){
            return;
        }

        for (String beanName : context.getBeanDefinitionNames()) {


            Object instance = context.getBean(beanName);

            Class<?> clazz = instance.getClass();

            if(!clazz.isAnnotationPresent(GPController.class)){
                continue;
            }

            //相当于提取class上配置的url
            String baseUrl = "";
            if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value().trim();
            }

            //只获取public的方法
            for (Method method : clazz.getMethods()) {

                if(!method.isAnnotationPresent(GPRequestMapping.class)){
                    continue;
                }

                //提取每个方法上面配置的url
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);

                // //demo//query
                String regex = ("/"+baseUrl +"/"+requestMapping.value().trim().replaceAll("\\*", ".*"))
                        .replaceAll("/+", "/");

                Pattern pattern = Pattern.compile(regex);
                //handlerMapping.put(url,method);

                handlerMappings.add(new GPHandlerMapping(pattern, instance, method));

                System.out.println("Mapped :"+regex+","+method);
            }


        }


    }
}
