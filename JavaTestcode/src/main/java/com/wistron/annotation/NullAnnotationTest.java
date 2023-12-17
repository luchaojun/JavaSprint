package com.wistron.annotation;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：Chaojun_Lu
 * @Date：2023/12/17 15:29
 * @Function： Null/SuppressWarning Annotation Test
 */
public class NullAnnotationTest {
    public static void testNullable(@Nullable String a) {
        if (a == null) {
            System.out.println("a=" + a);
        }
    }

    public static void testNonNull(@NotNull String a) {
        System.out.println("a=" + a);
    }

    public static void testEclipseNonNull(@NotNull String a) {
        System.out.println("a=" + a);
    }

    //        @SuppressWarnings({"unused"})   //消除变量没有被使用过的检查
    //        @SuppressWarnings("rawtypes") //消除多态的检查
    @SuppressWarnings({"unused", "unchecked", "rawtypes", "MismatchedQueryAndUpdateOfCollection"})
    public void testSuppressWarnings(){
        int i = 0;
        List list = new ArrayList<>();
        list.add("123");
    }

    public static void main(String[] args) {
        testNullable(null);
//        testNonNull(null);
        testEclipseNonNull(null);

    }
}
