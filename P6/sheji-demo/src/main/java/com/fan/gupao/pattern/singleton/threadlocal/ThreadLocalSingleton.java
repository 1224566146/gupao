package com.fan.gupao.pattern.singleton.threadlocal;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:48 2020/2/16
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){

    }

    private static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return THREAD_LOCAL.get();
    }

}
