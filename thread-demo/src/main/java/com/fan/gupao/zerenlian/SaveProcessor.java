package com.fan.gupao.zerenlian;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:41 2019/10/15
 */
public class SaveProcessor extends Thread implements IRequestProcessor {

    //阻塞式队列
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public SaveProcessor() {
    }

    public SaveProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {

        while (!isFinish) {

            try {
                Request request = requests.take();  //阻塞式获取数据
                requests.poll();
                //真正的处理逻辑
                System.out.println("SaveProcessor:" + System.currentTimeMillis() + ":currientThreadId:" + currentThread().getId() + request);

                //交给下一个责任链

                nextProcessor.process(request);

                System.out.println("SaveProcessor:" + System.currentTimeMillis() + ":currientThreadId:" + currentThread().getId());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void process(Request request) {
        System.out.println("SaveProcessor中的process方法" + System.currentTimeMillis() + ":currientThreadId:" + currentThread().getId() + request);
        requests.add(request);
    }
}
