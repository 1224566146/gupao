package com.fan.gupao.demo;

import java.util.concurrent.*;

/**
 * @author 樊高风
 * @Title: CallableDemo
 * @ProjectName p5-practice
 * @Description: CallableDemo
 * @date 2020/6/6 13:43
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("当前线程:"+Thread.currentThread().getName());
        Thread.sleep(10000);
        return "Hello 樊高风";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService =  Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(new CallableDemo());
        System.out.println(Thread.currentThread().getName()+"-"+submit.get());

    }
}
