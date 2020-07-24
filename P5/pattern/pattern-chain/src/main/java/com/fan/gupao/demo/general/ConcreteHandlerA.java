package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String request) {
        if("requestA".equals(request)){
            System.out.println(this.getClass().getSimpleName()+"deal with request:"+request);
            return;
        }
        if(this.nextHandler != null){
            this.nextHandler.handleRequest(request);
        }
    }
}
