package com.fan.gupao.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 樊高风
 * @Title: NewIOClient
 * @ProjectName socket-client-demo
 * @Description: TODO
 * @date 2020/6/10 11:27
 */
public class NewIOClient {

    static Selector selector;

    public static void main(String[] args) {

        try {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 9080));
            socketChannel.register(selector, SelectionKey.OP_CONNECT); // 连接事件
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isConnectable()) { // 连接事件
                        handleConnet(key);
                    } else if (key.isReadable()) {
                        handleRead(key);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void handleConnet(SelectionKey key) {
        try {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            if (socketChannel.isConnectionPending()) {

                socketChannel.finishConnect();
            }
            socketChannel.configureBlocking(false);
            socketChannel.write(ByteBuffer.wrap("Hello Server,I'm NIO Client".getBytes()));
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("client receive msg:"+new String(byteBuffer.array()));
    }

}
