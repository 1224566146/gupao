package com.fan.gupao;

import com.fan.gupao.zerenlian.*;

/**
 * Hello world!
 */
public class App {

    static IRequestProcessor requestProcessor;

    public void setUp() {

        PrintProcessor printProcessor = new PrintProcessor();

        new Thread(printProcessor,"printProcessor").start();

        SaveProcessor saveProcessor = new SaveProcessor(printProcessor);
        new Thread(saveProcessor,"saveProcessor").start();


        requestProcessor = new PrevProcessor(saveProcessor);
        new Thread((PrevProcessor)requestProcessor,"PrevProcessor").start();

    }

    public static void main(String[] args) {
        App app = new App();
        app.setUp();

        Request request = new Request();
        request.setName("笨笨");

        requestProcessor.process(request);
    }
}
