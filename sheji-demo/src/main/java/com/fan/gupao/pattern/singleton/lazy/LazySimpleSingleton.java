package com.fan.gupao.pattern.singleton.lazy;

/**
 * @Description: 懒汉式单例
 * @Author: 樊高风
 * @Date: 14:52 2020/2/16
 */
//在外部需要使用的时候才进行实例化
public class LazySimpleSingleton {

    private LazySimpleSingleton() {

    }

    //静态块、公共内存区域
    private static LazySimpleSingleton lazySimpleSingleton;

    public synchronized static LazySimpleSingleton getInstance() {
        if (lazySimpleSingleton == null) {
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }

}
