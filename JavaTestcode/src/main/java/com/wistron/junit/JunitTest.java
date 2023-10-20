package com.wistron.junit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class JunitTest {
    @BeforeClass
    public static void beforClass(){
        System.out.println("beforClass");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }

    //test1, test2调用前被调用
    @Before
    public void before(){
        System.out.println("before");
    }

    //test1, test2调用后被调用
    @After
    public void after(){
        System.out.println("after");
    }

    //代码出现ArithmeticException，此异常后面的代码不会再被执行
    @Test(expected = ArithmeticException.class)
    public void test1(){
        System.out.println("test1-before-ArithmeticException");
        int a = 10 / 0;
        System.out.println("test1-after-ArithmeticException");
    }

    //指定方法运行时间
    @Test(timeout = 3000)
    public void test2() throws InterruptedException {
        System.out.println("test2-before-sleep");
        Thread.sleep(2000);
        System.out.println("test2-after-sleep");
    }

    //忽略这个方法
    @Ignore
    public void test3(){
        System.out.println("test3方法");
    }
}
