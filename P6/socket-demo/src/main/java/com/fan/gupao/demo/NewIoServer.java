package com.fan.gupao.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 樊高风
 * @Title: NewIoServer
 * @ProjectName socket-demo
 * @Description: TODO
 * @date 2020/6/10 11:17
 */
public class NewIoServer {

    static Selector selector;

    public static void main(String[] args) {

        try {

            selector = Selector.open();
            // selector必须是非阻塞
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false); // 设置为非阻塞
            serverSocketChannel.socket().bind(new InetSocketAddress(9080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // 把连接事件注册到多路复用上
            while (true){

                selector.select(); // 阻塞机制
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if(key.isAcceptable()){ // 连接事件
                        handleAccept(key);
                    }else if(key.isReadable()){ // 读的就绪事件
                        handleRead(key);
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static void handleRead(SelectionKey key) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            socketChannel.read(byteBuffer); // 这里是不是一定有值
            System.out.println("server receive msg:"+new String(byteBuffer.array()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void handleAccept(SelectionKey key) {
        ServerSocketChannel serverSocketChannel =(ServerSocketChannel) key.channel();
        try {

            SocketChannel socketChannel = serverSocketChannel.accept();// 一定会有一个连接
            socketChannel.configureBlocking(false);
            socketChannel.write(ByteBuffer.wrap("Hello Client,I'm NIO Server".getBytes()));
            socketChannel.register(selector, SelectionKey.OP_READ); // 注册读事件
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
