package com.fan.gupao.pattern.proxy.simpleproxy;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:36 2020/3/2
 */
public class Client {
    public static void main(String[] args) {

        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();


    }
}
