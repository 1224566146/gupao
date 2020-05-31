package com.fan.gupao.pattern.proxy.simpleproxy;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:34 2020/3/2
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        this.subject.request();
        after();
    }

    public void before(){
        System.out.println("called before request().");
    }

    public void after(){
        System.out.println("called after request().");
    }
}
