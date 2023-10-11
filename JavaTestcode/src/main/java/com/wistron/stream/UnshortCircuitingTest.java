package com.wistron.stream;


import java.util.Arrays;
import java.util.List;

//非短路操作  --- 必须处理完所有元素才能得到最终结果
public class UnshortCircuitingTest {
    public static void main(String[] args) {
        //forEachOrdered方法的使用
//        Stream.of("AAA,","BBB,","CCC,","DDD,").parallel().forEach(System.out::print);
//        System.out.println("\n______________________________________________");
//        Stream.of("AAA,","BBB,","CCC,","DDD").parallel().forEachOrdered(System.out::print);
//        System.out.println("\n______________________________________________");
//        Stream.of("DDD,","AAA,","BBB,","CCC").parallel().forEachOrdered(System.out::print);

        //toArray方法的使用
//        People p1 = new People("chaojun1", 21);
//        People p2 = new People("chaojun2", 22);
//        People p3 = new People("chaojun3", 23);
//        List<People> list = Arrays.asList(p1, p2, p3);
//        People[] array = list.stream().toArray(People[]::new);

        //reduce方法的使用
//        List<Integer> list = Arrays.asList(30, 20, 10);
//        Integer i = list.stream().reduce((a, b) -> {
//            return a + b;
//        }).get();
//        System.out.println(i);


    }
}
