package com.gupaoedu.util;

import java.util.ResourceBundle;

/**
 * 配置文件读取工具类
 */
public class ResourceUtil {

    private static final ResourceBundle RESOURCE_BUNDLE;

    static {
        RESOURCE_BUNDLE = ResourceBundle.getBundle("config");
    }


    public static String getKey(String key){
        return RESOURCE_BUNDLE.getString(key);
    }

}
