package com.fan.gupao.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:16 2019/10/16
 */
public class ExceptionThreadDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) { //默认是false

                        try {
                            TimeUnit.SECONDS.sleep(10);    //中断一个处于阻塞状态的线程   join/wait/queue.take
                            System.out.println("demo");
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }

                    }
                    System.out.println("i:" + i);
                }
        );

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt(); //把isInterrupted设置成true

        System.out.println("输出isInterrupted:" + thread.isInterrupted());

    }
}
