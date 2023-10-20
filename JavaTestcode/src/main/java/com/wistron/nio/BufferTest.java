package com.wistron.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

//Buffer Test
public class BufferTest {
    
    @Test
    public void test1() {
        System.out.println("============allocate==========");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========put===========");
        String str = "chaojun";
        byteBuffer.put(str.getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========flip===========");
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========get===========");
        byte[] b = new byte[byteBuffer.limit()];
        byteBuffer.get(b);
        System.out.println(new String(b, 0, b.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========rewind===========");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("===========clear===========");
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println((char)byteBuffer.get());
    }

    @Test
    public void test2(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String str = "qinc";
        byteBuffer.put(str.getBytes());
        System.out.println("=====================flip=========================");
        byteBuffer.flip();
        byte[] b = new byte[byteBuffer.limit()];
        System.out.println("before get, position="+byteBuffer.position());
        byteBuffer.get(b,0,2);
        System.out.println(new String(b, 0, 2));
        System.out.println("after get(0,2), position="+byteBuffer.position());
        System.out.println("=====================mark=========================");
        byteBuffer.mark();
        byteBuffer.get(b, 2, 2);
        System.out.println(new String(b, 2, 2));
        System.out.println("after get(2,4), position="+byteBuffer.position());
        System.out.println(byteBuffer.hasRemaining());
        System.out.println("=====================reset========================");
        byteBuffer.reset();
        System.out.println("after get(2,4), position="+byteBuffer.position());
        //是否还有剩余数据
        System.out.println(byteBuffer.hasRemaining());
        //返回position和limit之间的元素个数
        System.out.println(byteBuffer.remaining());

        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(1024);
        System.out.println("isDirect="+byteBuffer1.isDirect());
    }
}
