package com.fan.gupao.demo.chain;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 22:23 2020/5/28
 */
public interface RequestProcessor {

    void processRequest(Request request);

    void shutDown();

}
