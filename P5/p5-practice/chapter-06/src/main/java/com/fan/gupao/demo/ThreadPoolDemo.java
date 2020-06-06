package com.fan.gupao.demo;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 樊高风
 * @Title: ThreadPoolDemo
 * @ProjectName p5-practice
 * @Description: ThreadPoolDemo
 * @date 2020/6/6 16:16
 */
public class ThreadPoolDemo implements Runnable {


    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) ExecutorsSelf.ThreadPoolSelf(3);

        for (int i = 0; i < 100; i++) {
            executor.execute(new ThreadPoolDemo());
        }
        executor.shutdown();

    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
