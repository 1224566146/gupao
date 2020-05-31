package com.fan.gupao.zerenlian;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:03 2019/10/15
 */
public class PrevProcessor extends Thread implements IRequestProcessor {
    //阻塞队列
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public PrevProcessor() {
    }

    public PrevProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void shutdown() {
        isFinish = true;
    }

    @Override
    public void run() {

        while (!isFinish) {  //不建议这么写
            try {
                Request request = requests.take();   //阻塞式获取数据
                //真正处理逻辑
                System.out.println("prevProcessor:" + System.currentTimeMillis() + ":currientThreadId:"+currentThread().getId()+ request);

                //交给下一个责任链
                nextProcessor.process(request);

                System.out.println("PrevProcessor:"+ System.currentTimeMillis()+ ":currientThreadId:"+currentThread().getId() );

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void process(Request request) {
        System.out.println("prevProcessor中的process方法"+ System.currentTimeMillis() + ":currientThreadId:"+currentThread().getId()+request);
        requests.add(request);
    }
}
