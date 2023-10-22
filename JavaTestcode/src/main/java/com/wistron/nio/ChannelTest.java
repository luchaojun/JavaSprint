package com.wistron.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

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

    //对BufferByte中的put(BufferByte b)方法进行测试
    @Test
    public void channelTest2() throws IOException {
        FileInputStream fos = new FileInputStream("niotest2");
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(4*4);
        fileChannel.read(byteBuffer);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(4*4*2);
        System.out.println(byteBuffer2.capacity());
        System.out.println(byteBuffer2.limit());
        System.out.println(byteBuffer2.position());
        byteBuffer.flip();
        byteBuffer2.put(byteBuffer);
        byteBuffer2.flip();
        System.out.println(byteBuffer2.capacity());
        System.out.println(byteBuffer2.limit());
        System.out.println(byteBuffer2.position());
        while(byteBuffer2.hasRemaining()){
            System.out.println((char)byteBuffer2.get());
        }
    }


    //创建数据给channelTest4方法进行测试
    @Test
    public void channelTest3() throws IOException {
        FileOutputStream fos = new FileOutputStream("niotest2");
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        for(int i=0;i<1000;i++){
            byteBuffer.put(("qin"+"\n").getBytes());
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();
    }

    //测试channel进行数据的读取
    @Test
    public void channelTest4() throws IOException {
        FileInputStream fis = new FileInputStream("niotest2");
        FileChannel fileChannel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        int read = fileChannel.read(byteBuffer);
        while (read != -1){
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                byte b = byteBuffer.get();
                if(b == 10){
                    byteBuffer2.flip();
                    String line = Charset.forName("utf-8").decode(byteBuffer2).toString();
                    System.out.println("line===="+line);
                    byteBuffer2.clear();
                }else{
                    if(byteBuffer2.hasRemaining()){
                        byteBuffer2.put(b);
                    }else{
                        byteBuffer2 = reAllocate(byteBuffer2);
                        byteBuffer2.put(b);
                    }
                }
            }
            byteBuffer.clear();
            read = fileChannel.read(byteBuffer);
        }
        byteBuffer2.flip();
        String line = Charset.forName("utf-8").decode(byteBuffer2).toString();
        System.out.println(line);
        fileChannel.close();
    }

    //channelTest方法byteBuffer2大小不够的时候， 进行扩容
    private ByteBuffer reAllocate(ByteBuffer byteBuffer2) {
        System.out.println("=================reAllocate操作============================");
        byteBuffer2.flip();
        ByteBuffer reAllocateByteBuffer = ByteBuffer.allocate(byteBuffer2.capacity() * 2);
        reAllocateByteBuffer.put(byteBuffer2);
        System.out.println(reAllocateByteBuffer.capacity());
        System.out.println(reAllocateByteBuffer.limit());
        System.out.println(reAllocateByteBuffer.position());
        return reAllocateByteBuffer;
    }

    //复制一个图片
    @Test
    public void channelTest5() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileInputStream fis = new FileInputStream("nv.jpg");
        FileOutputStream fos = new FileOutputStream("nv-copy.jpg");
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        int picRead = fisChannel.read(byteBuffer);
        while (picRead != -1){
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
            byteBuffer.clear();
            picRead = fisChannel.read(byteBuffer);
        }
        fisChannel.close();
        fosChannel.close();
    }

    //从目标通道中去复制原通道数据
    @Test
    public void channelTest6() throws IOException {
        FileInputStream fis = new FileInputStream("nv.jpg");
        FileOutputStream fos = new FileOutputStream("nv-copy.jpg");
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        System.out.println("fosChannel.position="+fosChannel.position()+",fosChannel.size()="+fosChannel.size());
        System.out.println("fisChannel.position="+fisChannel.position()+",fisChannel.size()="+fisChannel.size());
        fosChannel.transferFrom(fisChannel, fisChannel.position(), fisChannel.size());
        System.out.println("After transferFrom, fosChannel.position="+fosChannel.position()+",fosChannel.size()="+fosChannel.size());
        fisChannel.close();
        fosChannel.close();
    }

    //把原通道数据复制到目标通道
    @Test
    public void channelTest7() throws IOException {
        FileInputStream fis = new FileInputStream("nv.jpg");
        FileOutputStream fos = new FileOutputStream("nv-copy.jpg");
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        System.out.println("fosChannel.position="+fosChannel.position()+",fosChannel.size()="+fosChannel.size());
        System.out.println("fisChannel.position="+fisChannel.position()+",fisChannel.size()="+fisChannel.size());
        fisChannel.transferTo(fisChannel.position(), fisChannel.size(), fosChannel);
        System.out.println("After transferFrom, fosChannel.position="+fosChannel.position()+",fosChannel.size()="+fosChannel.size());
    }

    //分散(scatter)读取聚集(gathering)写入
    @Test
    public void channelTest8() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("scatter_gathering_file", "rw");
        FileChannel fileChannel = raf.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(400);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {byteBuffer1, byteBuffer2};
        fileChannel.read(buffers);
        for(ByteBuffer buffer: buffers){
            buffer.flip();
        }
        RandomAccessFile raf2 = new RandomAccessFile("scatter_gathering_file_copy", "rw");
        FileChannel fileChannel2 = raf2.getChannel();
        fileChannel2.write(buffers);
        fileChannel.close();
        fileChannel2.close();
    }
}
