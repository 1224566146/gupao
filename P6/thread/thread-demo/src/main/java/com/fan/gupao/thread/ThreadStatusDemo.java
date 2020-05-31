package com.fan.gupao.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:32 2019/10/15
 */
public class ThreadStatusDemo {

    private static int k = 1;

    //创建一个静态内部类
//    static class a implements Runnable {
//        @Override
//        public void run() {
//
//        }
//    }

    //阻塞类
    static class BlockedDemo extends Thread {
        @Override
        public void run() {

            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        System.out.println("进入BlockedDemo");
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }


    public static void main(String[] args) {
        //java8特性   lambda表达式来构建一个方法
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("进入Time_Waiting_Thread");
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Time_Waiting_Thread").start();

        //
        new Thread(
                () -> {
                    while (true) {
                        synchronized (ThreadStatusDemo.class) {
                            try {
                                k ++;
                                System.out.println("输出k:"+k);
                                System.out.println("进入Wating_Thread");
                                TimeUnit.SECONDS.sleep(100);
                             //   ThreadStatusDemo.class.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, "Wating_Thread"
        ).start();

        Thread thread = new Thread(
                ()->{
                    while (true) {
                        System.out.println("线程是否运行");
                        synchronized (ThreadStatusDemo.class) {
                             k++;
                            //   int k1 = new ThreadStatusDemo().k;
                            System.out.println("输出k1:" + k);
                        }
                    }
                },"syn1"
        );
        thread.start();

        new Thread(new BlockedDemo(),"Block01_Thread").start();
        new Thread(new BlockedDemo(),"Block02_Thread").start();

        //使用内部类来构建一个线程
//        new Thread(
//                new a() {
//                    public void run() {
//                        while (true) {
//                            try {
//                                TimeUnit.SECONDS.sleep(100);
//
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                    }
//                }, "Wating_Thread");
    }

}
