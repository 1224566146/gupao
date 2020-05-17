package com.fan.gupao.demo;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:10 2020/5/17
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {

        System.out.println("Come in ");
        Thread.sleep(10000);
        return "SUCCESS";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> submit = executorService.submit(callableDemo);
        System.out.println(submit.get()); //阻塞
        System.out.println("Main in");
    }
}
