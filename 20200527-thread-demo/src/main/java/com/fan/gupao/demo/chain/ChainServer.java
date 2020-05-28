package com.fan.gupao.demo.chain;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:30 2020/5/28
 */
public class ChainServer {

    private RequestProcessor firstProcessor;

    private void setUpRequestProcessor(){
        // 构建一个链路
        // print -> save -> final
        RequestProcessor finalProcessor = new FinalProcessor();
        RequestProcessor saveProcessor = new SaveProcessor(finalProcessor);
        firstProcessor = new PrintProcessor(saveProcessor);

        // 分别启动三个线程
        ((FinalProcessor) finalProcessor).start();
        ((SaveProcessor) saveProcessor).start();
        ((PrintProcessor)firstProcessor).start();
    }

    public void startUp(){
        setUpRequestProcessor();
    }

    public void shutDown(){
        firstProcessor.shutDown();
    }

    public static void main(String[] args) throws InterruptedException {


        ChainServer chainServer = new ChainServer();
        chainServer.startUp();

        Request request = new Request("樊高风");
        chainServer.firstProcessor.processRequest(request);

        Thread.sleep(5000);

        chainServer.shutDown();
    }

}
