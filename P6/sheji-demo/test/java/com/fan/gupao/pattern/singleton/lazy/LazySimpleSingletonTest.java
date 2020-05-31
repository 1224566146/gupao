package com.fan.gupao.pattern.singleton.lazy;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:59 2020/2/16
 */
public class LazySimpleSingletonTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();

        System.out.println("End");


    }
}
