package com.fan.gupao.thread.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author 樊高风
 * @Title: CountDownLatchDemo
 * @ProjectName 20200530-thread
 * @Description: TODO
 * @date 2020/5/31 16:27
 */
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "->begin");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "->end");
        }, "t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "->begin");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "->end");
        }, "t2").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "->begin");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "->end");
        }, "t3").start();

        countDownLatch.await();

    }

}
