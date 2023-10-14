package com.wistron.stream;


import java.util.ArrayList;
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

//        List<Integer> list = Arrays.asList(30, 20, 10);
//        Integer i = list.stream().reduce(100, (x, y) -> {
//            System.out.println("x="+x+",y="+y);
//            return x + y;
//        });
//        System.out.println(i);

        //collect方法的使用
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        list.stream().collect(()->{
//            System.out.println("创建一个容器");
//            return new ArrayList<Integer>();
//        }, (x, y)->{
//            System.out.println("累加器");
//            x.forEach(item -> System.out.println("x="+x));
//            System.out.println("y="+y);
//            x.add(y);
//        }, (x, y)->{
//
//        }).forEach(item-> System.out.println("最后结果="+item));

//        List<Integer> list = Arrays.asList(10, 9, 13);
//        list.stream().max(Integer::compare).ifPresent(System.out::println);

//        List<Integer> list = Arrays.asList(10, 9, 13);
//        long count = list.stream().count();
//        System.out.println(count);
    }
}
