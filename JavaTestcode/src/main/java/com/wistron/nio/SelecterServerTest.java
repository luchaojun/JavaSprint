package com.wistron.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

//NIO选择器代码测试
public class SelecterServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8989));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(selector.select() > 0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    handleAccept(key);
                }else if(key.isReadable()){
                    handleReadable(key);
                }
                iterator.remove();
            }
        }
        serverSocketChannel.close();
    }

    private static void handleReadable(SelectionKey key) throws IOException {
        System.out.println("handleReadable");
        SocketChannel socketChannel1 = (SocketChannel) key.channel();
        socketChannel1.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        socketChannel1.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
    }

    private static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        System.out.println("socketChannel="+socketChannel);
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("hello client".getBytes()));
        socketChannel.register(key.selector(), SelectionKey.OP_READ);
    }
}
