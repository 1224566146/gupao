package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: RunnableDemo
 * @ProjectName p5-practice
 * @Description: RunnableDemo
 * @date 2020/6/6 13:42
 */
public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("当前线程:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();
    }
}
