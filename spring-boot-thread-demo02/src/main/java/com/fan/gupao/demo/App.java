package com.fan.gupao.demo;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 8:54 2020/5/18
 */
public class App {

    public static int count = 0;
    static Object lock = new Object();

    public static void incr() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> App.incr()).start();
        }

        Thread.sleep(3000); // 保证线程执行结束
        System.out.println("运行结果：" + count);

    }

}
