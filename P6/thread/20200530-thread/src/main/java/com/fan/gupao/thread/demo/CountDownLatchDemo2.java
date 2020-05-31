package com.fan.gupao.thread.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author 樊高风
 * @Title: CountDownLatchDemo2
 * @ProjectName 20200530-thread
 * @Description: TODO
 * @date 2020/5/31 16:29
 */
public class CountDownLatchDemo2 implements Runnable {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new CountDownLatchDemo2()).start();
        }

        countDownLatch.countDown();

    }


    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
