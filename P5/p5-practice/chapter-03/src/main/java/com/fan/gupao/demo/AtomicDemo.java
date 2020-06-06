package com.fan.gupao.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 樊高风
 * @Title: AtomicDemo
 * @ProjectName p5-practice
 * @Description: AtomicDemo
 * @date 2020/6/6 14:30
 */
public class AtomicDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::incr).start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:"+atomicInteger.get());
    }

}
