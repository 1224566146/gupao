package com.fan.gupao.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author 樊高风
 * @Title: ThreadStatusDemo
 * @ProjectName p5-practice
 * @Description: ThreadStatusDemo
 * @date 2020/6/6 13:47
 */
public class ThreadStatusDemo {


    public static void main(String[] args) {

        // TIME_WAITING
        new Thread(()->{
           while (true){
               try {
                   TimeUnit.SECONDS.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"Time_Waiting_demo").start();

        // WAITING
        new Thread(()->{
            while (true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        // 等待阻塞
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Waiting").start();

        new Thread(new BlockedDemo(),"Blocked-Demo-01").start();
        new Thread(new BlockedDemo(),"Blocked-Demo-02").start();
    }

    static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
