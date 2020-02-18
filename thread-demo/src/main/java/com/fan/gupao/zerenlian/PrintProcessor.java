package com.fan.gupao.zerenlian;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:15 2019/10/15
 */
public class PrintProcessor extends Thread implements IRequestProcessor {
    //阻塞队列
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public PrintProcessor() {
    }

    public PrintProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void shutdown() {  //对外提供关闭的方法
        isFinish = true;
    }

    @Override
    public void run() {

        while (!isFinish) {

            try {

                Request request = requests.take(); //阻塞式获取数据    消费者

                System.out.println("PrintProcessor:" + System.currentTimeMillis()+ ":currientThreadId:"+currentThread().getId()+ request);

                //交给下一个责任链
                if (nextProcessor != null) {
                    nextProcessor.process(request);
                }

                System.out.println("PrintProcessor:"+ System.currentTimeMillis()+ ":currientThreadId:"+currentThread().getId() );

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void process(Request request) {
        System.out.println("PrintProcessor中的process方法"+ System.currentTimeMillis() + ":currientThreadId:"+currentThread().getId()+request);
        requests.add(request);
    }
}
