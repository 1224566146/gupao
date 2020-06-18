package com.fan.gupao.demo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        RpcProxyClient proxyClient = new RpcProxyClient();
        IOrderService orderService = proxyClient.clientProxy(IOrderService.class, "localhost", 9080);

        System.out.println(orderService.queryOrderList());
//        System.out.println( "Hello World!" );
    }
}
