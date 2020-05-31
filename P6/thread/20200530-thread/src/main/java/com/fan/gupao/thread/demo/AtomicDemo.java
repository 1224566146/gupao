package com.fan.gupao.thread.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 樊高风
 * @Title: AtomicDemo
 * @ProjectName 20200530-thread
 * @Description: TODO
 * @date 2020/5/31 16:37
 */
public class AtomicDemo {

    public static AtomicInteger i = new AtomicInteger(0);

    public static void incr(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        i.getAndIncrement();
    }

    public static void main(String[] args) {

        for (int j = 0; j < 1000; j++) {
            new Thread(()->{
                AtomicDemo.incr();
            }).start();
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("result:"+i);

    }

}
