package com.fan.gupao.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:20 2019/10/16
 */
public class ThreadResetDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        if (Thread.currentThread().isInterrupted()) {//默认是false
                            System.out.println("before:" + Thread.currentThread().isInterrupted());
                            Thread.interrupted();  //复位   回到初始状态
                            System.out.println("after:" + Thread.currentThread().isInterrupted());

                            Thread.currentThread().interrupt();
                        }
                        i++;
                    }
                    System.out.println("i:"+i);
                }, "ThreadReset_Thread");

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt();
    }
}
