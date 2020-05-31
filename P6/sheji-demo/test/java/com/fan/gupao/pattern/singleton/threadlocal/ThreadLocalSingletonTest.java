package com.fan.gupao.pattern.singleton.threadlocal;

import com.fan.gupao.pattern.singleton.lazy.ExectorThread;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:52 2020/2/16
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {

        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());


        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();

        System.out.println("End");

    }
}
