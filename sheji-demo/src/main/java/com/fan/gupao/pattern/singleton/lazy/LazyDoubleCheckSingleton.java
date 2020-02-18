package com.fan.gupao.pattern.singleton.lazy;

/**
 * @Description: 懒汉式双重锁单例
 * @Author: 樊高风
 * @Date: 15:29 2020/2/16
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton LAZY_DOUBLE_CHECK_SINGLETON = null;

    private LazyDoubleCheckSingleton() {

    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (LAZY_DOUBLE_CHECK_SINGLETON == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (LAZY_DOUBLE_CHECK_SINGLETON == null) {
                    LAZY_DOUBLE_CHECK_SINGLETON = new LazyDoubleCheckSingleton();
                }
                //1、分配内存给这个对象
                //2、初始化对象
                //3、设置对象指向刚分配的内存地址
                //4、初次访问对象
            }
        }
        return LAZY_DOUBLE_CHECK_SINGLETON;
    }

}
