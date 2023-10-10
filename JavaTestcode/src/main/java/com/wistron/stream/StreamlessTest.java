package com.wistron.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//无状态操作
public class StreamlessTest {
    public static void main(String[] args) {
        //filter方法的使用
//        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2);
//        Stream<Integer> stream = list.stream().filter(x->x>5);
//        stream.forEach(System.out::println);


        //mapper方法的使用
//        List<People> list = Stream.of("chaojun1:21", "chaojun2:22").map(s -> {
//            String[] str = s.split(":");
//            People people = new People(str[0], Integer.parseInt(str[1]));
//            return people;
//        }).collect(Collectors.toList());
//        System.out.println(list);


        //floatMap方法的使用
//        List<String> list1 = Arrays.asList("m,k,l,a", "1,3,5,7");
//        List<String> listNew = list1.stream().flatMap((s) -> {
//            String[] split = s.split(",");
//            Stream<String> stream2 = Arrays.stream(split);
//            return stream2;
//        }).collect(Collectors.toList());
//        System.out.println(list1);
//        System.out.println(listNew);

        Stream<String> stream = Stream.of("hello", "world");
        stream.peek(System.out::println).collect(Collectors.toList());
    }
}
class People{
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
