package com.fan.gupao.demo2;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:01 2020/5/17
 */
public class Demo {

    public static void main(String[] args) {

        new Thread(() ->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"STATUS_01").start(); //阻塞状态

        new Thread(() ->{
            while (true){
                synchronized (Demo.class){
                    try {
                        Demo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"STATUS_02").start(); //阻塞状态

        new Thread(new BlockDemo(),"BLOCKED-DEMO-01").start();
        new Thread(new BlockDemo(),"BLOCKED-DEMO-02").start();


    }

    static class BlockDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockDemo.class){
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
