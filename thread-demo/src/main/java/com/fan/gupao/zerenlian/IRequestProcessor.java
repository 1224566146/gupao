package com.fan.gupao.zerenlian;

/**
 * @Description:  责任链模式 公共接口
 * @Author: 樊高风
 * @Date: 10:00 2019/10/15
 */
public interface IRequestProcessor {

    void process(Request request);
}
