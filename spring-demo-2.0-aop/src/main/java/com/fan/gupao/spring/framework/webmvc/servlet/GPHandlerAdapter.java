package com.fan.gupao.spring.framework.webmvc.servlet;

import com.fan.gupao.spring.framework.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:51 2020/4/13
 */
public class GPHandlerAdapter {

    public GPModelAndView handler(HttpServletRequest req, HttpServletResponse resp, GPHandlerMapping handler) throws Exception {


        //保存形参列表
        //将参数名称和参数的位置，这种关系保存起来
        Map<String, Integer> paramIndexMapping = new HashMap<>();

        //通过运行时的状态去拿到
        Annotation[][] pa = handler.getMethod().getParameterAnnotations();

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


        //初始化一下
        Class<?>[] parameterTypes = handler.getMethod().getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> paramterType = parameterTypes[i];
            if (paramterType == HttpServletRequest.class || paramterType == HttpServletResponse.class) {
                paramIndexMapping.put(paramterType.getName(), i);
            }
        }


        //去拼接实参列表
        //http://localhost/web/query?name=tom&cat

        Map<String, String[]> params = req.getParameterMap();


        Object[] paramValue = new Object[parameterTypes.length];


        for (Map.Entry<String, String[]> param : params.entrySet()) {

            String value = Arrays.toString(params.get(param.getKey()))
                    .replaceAll("\\[|\\]", "")
                    .replaceAll("\\s+", ",");

            if (!paramIndexMapping.containsKey(param.getKey())) {
                continue;
            }

            int index = paramIndexMapping.get(param.getKey());

            //允许自定义的类型转换器
            paramValue[index] = castStringValue(value, parameterTypes[index]);

        }

        if (paramIndexMapping.containsKey(HttpServletRequest.class.getName())) {

            int index = paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValue[index] = req;
        }


        if (paramIndexMapping.containsKey(HttpServletResponse.class.getName())) {

            int index = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValue[index] = resp;
        }

        Object result = handler.getMethod().invoke(handler.getController(), paramValue);

        if (result == null || result instanceof Void) {
            return null;
        }

        boolean isModelAndView = handler.getMethod().getReturnType() == GPModelAndView.class;
        if (isModelAndView) {
            return (GPModelAndView) result;
        }

        return null;


    }

    private Object castStringValue(String value, Class<?> paramType) {
        if (String.class == paramType) {
            return value;
        } else if (Integer.class == paramType) {
            return Integer.valueOf(value);
        } else if (Double.class == paramType) {
            return Double.valueOf(value);
        } else {
            if (value != null) {
                return value;
            }
            return null;
        }
    }


}
