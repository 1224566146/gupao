package com.fan.gupao.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:03 2019/10/16
 */
public class InterruptDemo {

    private static int i ;


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){  //默认是false
                i ++;

            }
            System.out.println("i:"+i);
        },"Interrupted_Thread");

        thread.start();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("时间:"+sdf.format(new Date()));
        TimeUnit.SECONDS.sleep(1);


        System.out.println("结束时间:"+sdf.format(new Date()));
        System.out.println("主线程运行到此！！！！！");

        thread.interrupt();  //把isInterrupted设置成true
    }

}
