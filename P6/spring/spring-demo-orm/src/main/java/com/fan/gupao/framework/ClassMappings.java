package com.fan.gupao.framework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:15 2020/5/9
 */
public class ClassMappings {

    private ClassMappings() {
    }

    static final Set<Class<?>> SUPPORTED_SQL_OBJECTS = new HashSet<>();

    /**
     * 功能描述：静态代码块，注册支持自动转换的类型
     * @authorer: 樊高风
     * @date: 2020/5/9 15:32
     * @param:
     * @return:
     */
    static {
        // 只要这里写了的；默认支持自动类型转换
        Class<?>[] classes = {
                boolean.class, Boolean.class,
                short.class, Short.class,
                int.class, Integer.class,
                long.class, Long.class,
                float.class, Float.class,
                double.class, Double.class,
                String.class,
                Date.class,
                Timestamp.class,
                BigDecimal.class
        };
        SUPPORTED_SQL_OBJECTS.addAll(Arrays.asList(classes));
    }

    /**
     * 功能描述：是否支持转换成SQL对象
     *
     * @authorer: 樊高风
     * @date: 2020/5/9 15:19
     * @param:
     * @return:
     */
    static boolean isSupportedSQLObject(Class<?> clazz) {
        return clazz.isEnum() || SUPPORTED_SQL_OBJECTS.contains(clazz);
    }

    /**
     * 功能描述：找到所有公共get方法
     *
     * @param clazz 传入的类
     * @authorer: 樊高风
     * @date: 2020/5/9 15:25
     * @return:
     */
    public static Map<String, Method> findPublicGetters(Class<?> clazz) {
        Map<String, Method> map = new HashMap<>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers())) {
                continue;
            }
            if (method.getParameterTypes().length != 0) {
                continue;
            }
            if (method.getName().equals("getClass")) {
                continue;
            }
            Class<?> returnType = method.getReturnType();
            if (void.class.equals(returnType)) {
                continue;
            }
            if (!isSupportedSQLObject(returnType)) {
                continue;
            }
            if ((returnType.equals(boolean.class)
                    || returnType.equals(Boolean.class))
                    && method.getName().startsWith("is")
                    && method.getName().length() > 2) {
                map.put(getGetterName(method), method);
                continue;
            }
            if (!method.getName().startsWith("get")) {
                continue;
            }
            if (method.getName().length() < 4) {
                continue;
            }
            map.put(getGetterName(method), method);
        }
        return map;
    }

    /**
     * 功能描述：获取类中所有字段
     *
     * @param clazz 传入的类
     * @authorer: 樊高风
     * @date: 2020/5/9 15:24
     * @return:
     */
    public static Field[] findFields(Class<?> clazz) {
        return clazz.getDeclaredFields();
    }

    /**
     * 功能描述：获取所有setter方法
     *
     * @param clazz 传入的类
     * @authorer: 樊高风
     * @date: 2020/5/9 15:31
     * @return:
     */
    public static Map<String, Method> findPublicSetters(Class<?> clazz) {
        Map<String, Method> map = new HashMap<>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers())) {
                continue;
            }
            if (!void.class.equals(method.getReturnType())) {
                continue;
            }
            if (method.getParameterTypes().length != 1) {
                continue;
            }
            if (!method.getName().startsWith("set")) {
                continue;
            }
            if (method.getName().length() < 4) {
                continue;
            }
            if (!isSupportedSQLObject(method.getParameterTypes()[0])) {
                continue;
            }
            map.put(getSetterName(method), method);
        }
        return map;
    }

    /**
     * 功能描述：获取getter方法名
     *
     * @param getter 传入的方法
     * @authorer: 樊高风
     * @date: 2020/5/9 15:31
     * @return:
     */
    public static String getGetterName(Method getter) {
        String name = getter.getName();
        if (name.startsWith("is")) {
            name = name.substring(2);
        } else {
            name = name.substring(3);
        }
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }

    /**
     * 功能描述：获取Setter方法名
     *
     * @param setter 传入的方法
     * @authorer: 樊高风
     * @date: 2020/5/9 15:30
     * @return:
     */
    private static String getSetterName(Method setter) {
        String name = setter.getName().substring(3);
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }

}
