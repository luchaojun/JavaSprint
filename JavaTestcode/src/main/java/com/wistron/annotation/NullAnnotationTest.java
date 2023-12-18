package com.wistron.annotation;

//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
import org.eclipse.jdt.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：Chaojun_Lu
 * @Date：2023/12/17 15:29
 * @Function： Null/SuppressWarning Annotation Test
 */
public class NullAnnotationTest {
//    public static void testJetBrainsNullable(@Nullable String a) {
//        if (a == null) {
//            System.out.println("a=" + a);
//        }
//    }
//
//    public static void testJetBrainsNonNull(@NotNull String a) {
//        System.out.println("a=" + a);
//    }

    public static void testEclipseNullable(@Nullable String a) {
        if (a == null) {
            System.out.println("a=" + a);
        }
    }

    public static String testEclipseNonNull(@NonNull String a) {   //@NonNul的作用是调用的方法如果参数是null, 会变黄
        return a;
    }

    //        @SuppressWarnings({"unused"})   //消除变量没有被使用过的检查
    //        @SuppressWarnings("rawtypes") //消除多态的检查
    @SuppressWarnings({"unused", "unchecked", "rawtypes","MismatchedQueryAndUpdateOfCollection"})
    public void testSuppressWarnings(){
        int i = 0;
        List list = new ArrayList();
        list.add("123");
    }

    public static void main(String[] args) {
//        testJetBrainsNullable(null);
//        testJetBrainsNonNull(null);
        testEclipseNullable(null);
        testEclipseNonNull("a");
    }
}
