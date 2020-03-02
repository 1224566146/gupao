package com.fan.gupao.pattern.proxy.dbroute.db;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:48 2020/3/2
 */
public class DynamicDataSourceEntity {

    public final static String DEFAULE_SOURCE = null;

    private final static ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    private DynamicDataSourceEntity() {

    }

    public static String get() {
        return LOCAL.get();
    }

    public static void restore() {
        LOCAL.set(DEFAULE_SOURCE);
    }

    public static void set(String source) {
        LOCAL.set(source);
    }

    public static void set(int year) {
        LOCAL.set("DB_" + year);
    }

}
