package com.fan.gupao.demo.demo;

import java.util.Queue;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:17 2020/5/18
 */
public class Product implements Runnable {

    private Queue<String> msg;
    private int maxSize;

    public Product(Queue<String> msg, int maxSize) {
        this.msg = msg;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {

        int i = 0;
        while (true) {
            i++;
            synchronized (msg) { // 同一把锁
                while (msg.size() == maxSize) {
                    // 如果生产满了
                    try {
                        msg.wait();  // 一定会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者生产消息:" + i);
                msg.add("生产消息:" + i);
                msg.notify(); // 唤醒处于阻塞状态下的线程
            }

        }

    }
}
