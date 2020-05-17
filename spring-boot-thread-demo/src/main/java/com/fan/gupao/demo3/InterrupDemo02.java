package com.fan.gupao.demo3;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:16 2020/5/17
 */
public class InterrupDemo02 implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){ // false
            try {
                TimeUnit.SECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // 可以不做处理
                // 继续中断
                Thread.currentThread().interrupt(); // 再次中断
                // 抛出异常...
            }

        }
        System.out.println("processor End");
    }

    public static void main(String[] args) throws InterruptedException {


        Thread t1=new Thread(new InterrupDemo02());
        t1.start();
        Thread.sleep(1000);
        t1.interrupt(); //有作用 true
        //Thread.interrupted() ;//复位

    }
}
