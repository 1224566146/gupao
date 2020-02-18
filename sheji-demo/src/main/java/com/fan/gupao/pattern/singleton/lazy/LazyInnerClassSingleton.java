package com.fan.gupao.pattern.singleton.lazy;

/**
 * @Description: 懒汉式单例
 * @Author: 樊高风
 * @Date: 15:06 2020/2/16
 */
    //这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
    //完美地屏蔽了这俩个缺点
    //史上最牛逼的单例模式实现方式
public class LazyInnerClassSingleton {

    //默认使用LazyInnerClassSingletonGeneral的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private LazyInnerClassSingleton(){
        if(LazyHolder.LAZY_INNER_CLASS_SINGLETON != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    //每一个关键字都不是多余的
    //static是为了使单例的空间共享
    //final是保证这个方法不会被重写，重载
    public static final LazyInnerClassSingleton getInstance(){
        //在返回结果之前，一定会先加载内部类
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }

    //默认不加载
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
    }

}
