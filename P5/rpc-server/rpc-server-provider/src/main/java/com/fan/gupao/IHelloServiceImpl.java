package com.fan.gupao;

/**
 * @author 樊高风
 * @date 2020/6/13 15:28
 */
public class IHelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String content) {
        return "Hello Content:"+content;
    }
}
