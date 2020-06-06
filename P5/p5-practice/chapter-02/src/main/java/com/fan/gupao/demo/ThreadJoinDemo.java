package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: ThreadJoinDemo
 * @ProjectName p5-practice
 * @Description: ThreadJoinDemo
 * @date 2020/6/6 14:16
 */
public class ThreadJoinDemo {


    private static int x = 0;
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            // 阻塞操作
            i = 1;
            x = 2;
        });

        Thread t2 = new Thread(()->{
            i = x +2;
        });

        // 两个线程的执行顺序
        t1.start();
        t1.join(); // t1线程的执行结果对于t2线程可见（t1线程一定要比t2线程优先执行） -- 阻塞
        t2.start();
        Thread.sleep(1000);
        System.out.println("result:"+i);
    }

}
