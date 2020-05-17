package com.fan.gupao.demo3;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:13 2020/5/17
 */
public class InterruptDemo implements Runnable {

    private int i =1 ;

    @Override
    public void run() {

        // Thread.currentThread().isInterrupted() = false
        // 表示一个中断的标记 interrupted=false
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Test:"+i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt(); // 设置interrupted = true

    }
}
