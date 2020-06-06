package com.fan.gupao.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


public class TestMain {

    public static void main(String[] args) {
        Account fromAccount=new Account("张三",100000);
        Account toAccount=new Account("李四",200000);
       /* Thread a=new Thread(new TransferAccount(fromAccount,toAccount,1));
        Thread b=new Thread(new TransferAccount(toAccount,fromAccount,2));*/
        Allocator allocator=new Allocator(); //统一分配锁
        /*Thread a=new Thread(new TransferAccount01(fromAccount,toAccount,1,allocator));
        Thread b=new Thread(new TransferAccount01(toAccount,fromAccount,2,allocator));*/
       /* Thread a=new Thread(new TransferAccount02(fromAccount,toAccount,1));
        Thread b=new Thread(new TransferAccount02(toAccount,fromAccount,2));*/
        Thread a=new Thread(new TransferAccount03(fromAccount,toAccount,1));
        Thread b=new Thread(new TransferAccount03(toAccount,fromAccount,2));
        a.start();
        b.start();
    }

    /**
     * 腾讯课堂搜索【咕泡学院】
     * 官网：www.gupaoedu.com
     * 风骚的Mic 老师
     * create-date: 2019/11/28-21:39
     */
    public static class ForkJoinDemo extends RecursiveTask<Integer> {
        //计算1...10的累加
        //分割的阈值: 每个任务的大小 2
        private final int THREHOLD=2;
        private int start;
        private int end;

        public ForkJoinDemo(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum=0;
            boolean canCompute=(end-start)<=THREHOLD;
            if(canCompute){ //不能分割
                System.out.println("start:"+start+"-end:"+end);
                for(int i=start;i<=end;i++){
                    sum+=i;
                }
            }else{
                int middle=(start+end)/2;
                ForkJoinDemo left=new ForkJoinDemo(start,middle);
                ForkJoinDemo right=new ForkJoinDemo(middle+1,end);
                left.fork();
                right.fork();
                int leftResult=left.join();
                int rightResult=right.join();
                sum=leftResult+rightResult;
            }
            return sum;
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ForkJoinPool forkJoinPool=new ForkJoinPool();
            ForkJoinDemo forkJoinDemo=new ForkJoinDemo(1,10);
            Future<Integer> result=forkJoinPool.submit(forkJoinDemo);
            System.out.println(result.get());
        }
    }
}
