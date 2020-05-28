package com.fan.gupao.demo.chain;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:23 2020/5/28
 */
public class PrintProcessor extends Thread implements RequestProcessor {

    RequestProcessor nextProcessor;

    // 存储请求的数据
    BlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    volatile boolean finished = false;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }


    @Override
    public void run() {
        while (!finished){
            try {
                Request take = requests.take();// 阻塞式的获取请求
                System.out.println("Request:"+take);
                nextProcessor.processRequest(take); // 传递给下一个处理器
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request);  // 生产消息
    }

    @Override
    public void shutDown() {
        System.out.println("PrintProcessor begin shutDown");
        finished = true;
        requests.clear();
        nextProcessor.shutDown();
    }
}
