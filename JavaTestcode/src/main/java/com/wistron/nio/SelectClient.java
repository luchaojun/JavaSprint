package com.wistron.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SelectClient {

    private static Selector selector;

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        selector = Selector.open();
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("localhost", 8989));

        while(selector.select() > 0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey2 = iterator.next();
                if(selectionKey2.isConnectable()){
                    handleConnect(selectionKey2);
                }else if(selectionKey2.isReadable()){
                    handleReadable(selectionKey2);
                }
                iterator.remove();
            }
        }
            socketChannel.close();
    }

    private static void handleReadable(SelectionKey key) throws IOException {
        SocketChannel socketChannel1 = (SocketChannel) key.channel();
        socketChannel1.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        socketChannel1.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
    }

    public static void handleConnect(SelectionKey key) throws IOException {
        System.out.println("连接成功");
        SocketChannel socketChannel1 = (SocketChannel) key.channel();
        if(socketChannel1.isConnectionPending()){
            socketChannel1.finishConnect();
        }
        System.out.println("完成连接");
        socketChannel1.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String msg = "hello server";
        socketChannel1.write(ByteBuffer.wrap(msg.getBytes()));
        socketChannel1.register(selector, SelectionKey.OP_READ);
    }
}
