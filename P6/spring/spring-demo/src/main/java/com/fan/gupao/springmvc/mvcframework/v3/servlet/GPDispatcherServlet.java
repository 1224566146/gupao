package com.fan.gupao.springmvc.mvcframework.v3.servlet;

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
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:03 2020/3/29
 */
public class GPDispatcherServlet extends HttpServlet {

    private static final String LOCATION = "contextConfigLocation";

    private Properties p = new Properties();

    private List<String> classNames = new ArrayList<>();

    private Map<String, Object> ioc = new HashMap<>();

    //保存所有的url和方法的映射关系
    private List<Handerl> handlerMapping = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /**
     * 功能描述：执行业务处理
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 21:41
     * @param:
     * @return:
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDipatch(req, resp);//开始匹配到对应的方法
        } catch (Exception e) {
            //如果匹配过程出现异常，将异常信息打印出去
            resp.getWriter().write("500 Exception,Details:\r\n" + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]", "")
                    .replaceAll(",\\s", "\r\n"));
        }
    }

    /**
     * 功能描述：匹配URL
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 21:44
     * @param:
     * @return:
     */
    private void doDipatch(HttpServletRequest req, HttpServletResponse resp) {

        try {

            Handerl handler = getHandler(req);

            if (handler == null) {
                //如果没有匹配上，返回404错误
                resp.getWriter().write("404 NOT FOUND");
                return;
            }

            //获取方法的参数列表
            Class<?>[] parameterTypes = handler.method.getParameterTypes();

            //保存所有需要自动赋值的参数
            Object[] paramValues = new Object[parameterTypes.length];

            Map<String, String[]> params = req.getParameterMap();

            for (Map.Entry<String, String[]> param : params.entrySet()) {

                String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "")
                        .replaceAll(",\\s", ",");

                //如果找到匹配对象，则开始填充参数值
                if (!handler.paramIndexMapping.containsKey(param.getKey())) {
                    continue;
                }
                int index = handler.paramIndexMapping.get(param.getKey());
                paramValues[index] = conver(parameterTypes[index], value);

            }

            //设置方法中的request和response对象
            int reqIndex = handler.paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] = req;

            int respIndex = handler.paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] = resp;

            handler.method.invoke(handler.controller, paramValues);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 功能描述:类型转换
     * url传过来的参数都是String类型的，HTTP是基于字符串协议
     * 只需要把String转换为任意类型就好
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 21:57
     * @param:
     * @return:
     */
    private Object conver(Class<?> parameterType, String value) {

        if (Integer.class == parameterType) {
            return Integer.valueOf(value);
        }
        //如果还有double或者其他类型，继续加if
        //这时候，我们应该想到策略模式了
        //在这里暂时不实现，希望小伙伴自己来实现
        return value;
    }

    private Handerl getHandler(HttpServletRequest req) throws Exception {

        if (handlerMapping.isEmpty()) {
            return null;
        }

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");

        for (Handerl handerl : handlerMapping) {
            try {
                Matcher matcher = handerl.pattern.matcher(url);

                //如果没有匹配上继续下一个匹配
                if (!matcher.matches()) {
                    continue;
                }
                return handerl;
            } catch (Exception e) {
                throw e;
            }

        }
        return null;
    }


    /**
     * 功能描述：初始化，加载配置文件
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 20:07
     * @param:
     * @return:
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

        //1、加载配置文件
        doLoadConfig(config.getInitParameter(LOCATION));

        //2、扫描所有相关的类
        doScanner(p.getProperty("scanPackage"));

        //3、初始化所有相关的实例，并保存到IOC容器中
        doInstance();

        //4、依赖注入
        doAutowired();

        //5、构造HandlerMapping
        initHandlerMapping();

        //6、等待请求、匹配URL，定位方法，反射调用执行
        //调用doGet或者doPost方法

        //提示信息
        System.out.println("gupaoedu mvcframework is init");


    }

    /**
     * 功能描述：构造HandlerMapping
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 20:12
     * @param:
     * @return:
     */
    private void initHandlerMapping() {

        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {

            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(GPController.class)) {
                continue;
            }

            String url = "";
            //获取Controller的url配置
            if (clazz.isAnnotationPresent(GPRequestMapping.class)) {
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                url = requestMapping.value();

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
                String regex = ("/" + url + requestMapping.value()).replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(regex);
                handlerMapping.add(new Handerl(pattern, entry.getValue(), method));
                System.out.println("mapping" + regex + "," + method);


            }


        }


    }

    /**
     * 功能描述：依赖注入
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 20:11
     * @param:
     * @return:
     */
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

    /**
     * 功能描述：初始化所有相关的实例，并保存到IOC容器中
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 20:11
     * @param:
     * @return:
     */
    private void doInstance() {

        if (classNames.size() == 0) {
            return;
        }

        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(GPController.class)) {
                    //默认将首字母小写作为beanName
                    String beanName = lowerFirst(clazz.getSimpleName());
                    ioc.put(beanName, clazz.newInstance());

                } else if (clazz.isAnnotationPresent(GPService.class)) {
                    GPService service = clazz.getAnnotation(GPService.class);
                    String beanName = service.value();
                    //如果用户设置了名字，就用用户自己设置的
                    if (!"".equals(beanName.trim())) {
                        ioc.put(beanName, clazz.newInstance());
                        continue;
                    }
                    //如果自己没设置，就按接口类型创建一个实例
                    Class<?>[] interfaces = clazz.getInterfaces();
                    for (Class<?> i : interfaces) {
                        ioc.put(i.getName(), clazz.newInstance());
                    }
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 功能描述:将首字母转换成小写
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 21:14
     * @param:
     * @return:
     */
    private String lowerFirst(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 功能描述：扫描所有相关的类、递归扫描出所有Class文件
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 20:10
     * @param:
     * @return:
     */
    private void doScanner(String scanPackge) {

        //将所有的包路径转换为文件路径
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackge.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());

        for (File file : dir.listFiles()) {
            //如果是文件夹，继续递归
            if (file.isDirectory()) {
                doScanner(scanPackge + "." + file.getName());
            } else {
                classNames.add(scanPackge + "." + file.getName().replace(".class", "").trim());
            }
        }


    }

    /**
     * 功能描述：加载配置文件
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 20:09
     * @param:
     * @return:
     */
    private void doLoadConfig(String location) {
        InputStream is = null;

        try {

            is = this.getClass().getClassLoader().getResourceAsStream(location);
            //1、读取配置文件
            p.load(is);

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


    /**
     * 功能描述：内部类
     *
     * @authorer: 樊高风
     * @date: 2020/3/29 21:29
     * @param:
     * @return:
     */
    private class Handerl {

        protected Object controller; //保存方法对应的实例

        protected Method method; //保存映射的方法

        protected Pattern pattern;

        protected Map<String, Integer> paramIndexMapping;   //参数顺序

        public Handerl(Pattern pattern, Object controller, Method method) {
            this.controller = controller;
            this.method = method;
            this.pattern = pattern;

            paramIndexMapping = new HashMap<>();
            putParamIndexMapping(method);
        }

        /**
         * 功能描述:对应参数位置
         *
         * @authorer: 樊高风
         * @date: 2020/3/29 21:32
         * @param:
         * @return:
         */
        private void putParamIndexMapping(Method method) {

            //提取方法加了注解的参数
            Annotation[][] pa = method.getParameterAnnotations();
            for (int i = 0; i < pa.length; i++) {
                for (Annotation a : pa[i]) {
                    if (a instanceof GPRequestParam) {
                        String paramName = ((GPRequestParam) a).value();
                        if (!"".equals(paramName.trim())) {
                            paramIndexMapping.put(paramName, i);
                        }

                    }

                }

            }

            //提取方法中的request和response参数
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> type = parameterTypes[i];
                if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                    paramIndexMapping.put(type.getName(), i);

                }
            }


        }
    }

}
