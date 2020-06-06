package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: InterruptDemo
 * @ProjectName p5-practice
 * @Description: InterruptDemo
 * @date 2020/6/6 14:09
 */
public class InterruptDemo {

    private static int i;

    // interrupt(jvm)
    // while
    // 线程处于阻塞状态的情况下（中断才有意义）
    // thread.join
    // wait
    // Thread.sleep

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            // Thread.currentThread().isInterrupted()默认是false
            // 正常的任务处理
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 抛出异常来响应客户端的中断请求
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(500);
        // interupt这个属性由false - true
        thread.interrupt(); // 中断(友好)
    }

}
