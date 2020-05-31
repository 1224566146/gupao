package com.fan.gupao.springmvc.mvcframework.v2.servlet;

import com.fan.gupao.springmvc.mvcframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 18:54 2020/3/26
 */
public class GPDispatcherServlet extends HttpServlet {

    //存储application.properties的配置内容
    private Properties contextConfig = new Properties();

    //存储所有扫描到的类
    private List<String> classNames = new ArrayList<String>();

    //IOC容器，保存所有实例化对象
    //注册式单例模式
    private Map<String, Object> ioc = new HashMap<String, Object>();

    //保存controller中所有的Mapping关系
    private Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //派遣、分发任务
        try {
            //委派模式
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Excetion Detail:" + Arrays.toString(e.getStackTrace()));
        }
    }

//    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
//
//        String url = req.getRequestURI();
//        String contextPath = req.getContextPath();
//        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");
//
//        if (!this.handlerMapping.containsKey(url)) {
//            resp.getWriter().write("404 NOT Found！！");
//            return;
//        }
//
//        Method method = this.handlerMapping.get(url);
//
//        //第一个参数：方法所在的实例
//        //第二个参数：调用时所需要的实参
//
//        Map<String, String[]> params = req.getParameterMap();
//
//        //投机取巧的方式
//        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
//        method.invoke(ioc.get(beanName), new Object[]{req, resp, params.get("name")[0]});
//        System.out.println(method);
//
//    }


    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");

        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 NOT Found！！");
            return;
        }

        Method method = this.handlerMapping.get(url);

        //第一个参数：方法所在的实例
        //第二个参数：调用时所需要的实参
        Map<String, String[]> params = req.getParameterMap();

        //获取方法的形参列表
        Class<?>[] parameterTypes = method.getParameterTypes();

        //保存请求的url参数列表
        Map<String, String[]> parameterMap = req.getParameterMap();

        //保存赋值参数的位置
        Object[] paramValues = new Object[parameterTypes.length];

        //根据参数位置动态赋值
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class) {

                paramValues[i] = req;
                continue;

            } else if (parameterType == HttpServletResponse.class) {
                paramValues[i] = resp;
                continue;
            } else if (parameterType == String.class) {
                //提取方法中加了注解的参数
                Annotation[][] pa = method.getParameterAnnotations();
                for (int j = 0; j < pa.length; j++) {
                    for (Annotation a : pa[i]) {
                        if (a instanceof GPRequestParam) {
                            String paramName = ((GPRequestParam) a).value();
                            if (!"".equals(paramName.trim())) {
                                String value = Arrays.toString(parameterMap.get(paramName)).replaceAll("\\[|\\]", "").replaceAll("\\s", "");
                                paramValues[i] = value;
                            }

                        }

                    }
                }

            }
        }
        //投机取巧的方式
        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        method.invoke(ioc.get(beanName), new Object[]{req, resp, params.get("name")[0]});
        System.out.println(method);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        //模版模式

        //1、加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2、扫描相关的类
        doScanner(contextConfig.get("scanPackage").toString());
        //3、初始化所有相关的类的实例，并且放入到IOC容器之中
        doInstance();
        //4、完成依赖注入
        doAutowired();
        //5、初始化HandlerMapping
        initHandlerMapping();

        System.out.println("GP Spring framework is init");


    }

    //初始化HandlerMapping
    private void initHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(GPController.class)) {
                continue;
            }
            String baseUrl = "";
            //获取Controller的配置
            if (clazz.isAnnotationPresent(GPRequestMapping.class)) {
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            //获取Method的url配置
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                //没有加RequestMapping注解直接忽略
                if (!method.isAnnotationPresent(GPRequestMapping.class)) {
                    continue;
                }
                //映射URL
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                // /demo/query
                // (//demo//query)
                String url = ("/" + baseUrl + "/" + requestMapping.value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                System.out.println("Mapper" + url + "," + method);
            }
        }
    }

    //完成依赖注入
    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            //拿到实例对象中的所有属性
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(GPAutowired.class)) {
                    continue;
                }
                GPAutowired autowired = field.getAnnotation(GPAutowired.class);
                String beanName = autowired.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }
                //不管你愿意不愿意，强吻
                field.setAccessible(true);//设置私有属性的访问权限
                try {
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }

    //初始化所有相关的类实例，并且放入到IOC容器之中
    //控制反转过程
    //工厂模式来实现的
    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(GPController.class)) {
                    Object instance = clazz.newInstance();
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName, instance);
                } else if (clazz.isAnnotationPresent(GPService.class)) {
                    //1、默认的类名首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    //2、自定义命名
                    GPService service = clazz.getAnnotation(GPService.class);
                    if (!"".equals(service.value())) {
                        beanName = service.value();
                    }
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
                    //3、根据类型注入实现类，投机取巧的方式
                    for (Class<?> i : clazz.getInterfaces()) {
                        if (ioc.containsKey(i.getName())) {
                            throw new Exception("The BeanName is exists!!");
                        }
                        ioc.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //将首字母小写
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    //扫描相关的类
    private void doScanner(String scanPackage) {
        //包传过来包下面的所有的类全部扫描过来
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = (scanPackage + "." + file.getName()).replace(".class", "");
                classNames.add(className);
            }
        }

    }

    //加载配置文件
    private void doLoadConfig(String contextConfigLocation) {
        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
            //1、读取配置文件
            contextConfig.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
