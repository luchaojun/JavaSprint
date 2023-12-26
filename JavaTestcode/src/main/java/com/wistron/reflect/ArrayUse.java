package com.wistron.reflect;

import java.lang.reflect.Array;

/**
 * @Author: Chaojun_Lu
 * @Date: 20231226 11:02
 * @Function: 利用反射创建数组
 */
public class ArrayUse {
    public static void main(String[] args) {
        Object array = Array.newInstance(String.class, 3);
        Array.set(array, 0 , "A");
        Array.set(array, 1 , "B");
        Array.set(array, 2 , "C");

        System.out.println(Array.get(array, 2));
    }
}
