package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public abstract class Handler {

    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String request);
}
