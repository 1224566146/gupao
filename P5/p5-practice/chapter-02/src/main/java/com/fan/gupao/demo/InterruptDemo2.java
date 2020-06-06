package com.fan.gupao.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author 樊高风
 * @Title: InterruptDemo
 * @ProjectName p5-practice
 * @Description: InterruptDemo
 * @date 2020/6/6 14:09
 */
public class InterruptDemo2 {

    private static int i;

    // interrupt(jvm)
    // while
    // 线程处于阻塞状态的情况下（中断才有意义）
    // thread.join
    // wait
    // Thread.sleep

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while (true){
                // true标识被中断过
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                    Thread.interrupted(); // 对中断标识复位 false
                    System.out.println("after:"+Thread.currentThread().isInterrupted());

                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        // interupt这个属性由false - true
        thread.interrupt(); // 中断(友好)
    }

}
