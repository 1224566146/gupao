package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/18 9:55
 */
public class BootStrap {

    public static void main(String[] args) {

        IOrderService orderService = new OrderServiceImpl();
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(orderService, 9080);

    }

}
