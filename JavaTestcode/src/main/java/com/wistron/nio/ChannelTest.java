package com.wistron.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
    //测试写数据到文件
    @Test
    public void channelTest() throws IOException {
        FileOutputStream fos = new FileOutputStream("niotest");
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("===========buffer allocate============");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        for(int i=0;i<10;i++){
            System.out.println("==============loop "+ i +"===============");
            byteBuffer.clear();
            System.out.println("==============buffer put===============");
            byteBuffer.put("123".getBytes());
            System.out.println(byteBuffer.position());
            System.out.println(byteBuffer.limit());
            System.out.println(byteBuffer.capacity());
            System.out.println("==============buffer flip===============");
            byteBuffer.flip();
            System.out.println(byteBuffer.position());
            System.out.println(byteBuffer.limit());
            System.out.println(byteBuffer.capacity());
            System.out.println("==============buffer write===============");
            fileChannel.write(byteBuffer);
            System.out.println(byteBuffer.position());
            System.out.println(byteBuffer.limit());
            System.out.println(byteBuffer.capacity());
        }
        fileChannel.close();
    }
}
