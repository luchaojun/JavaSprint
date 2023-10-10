package com.wistron.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Stream构成和创建
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "Stream");

        //通过用java.util.Collections.stream()方法用集合创建流
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        //通过java.util.Arrays.stream(T[] array) 方法用数组创建流
        String[] array = {"h", "e", "l", "l", "o"};
        Stream<String> arrayStream = Arrays.stream(array);

        //Stream的静态方法
        Stream<Integer> ofStream = Stream.of(1, 2, 3);
        Stream<Integer> iterateStream = Stream.iterate(1, (x) -> x + 2).limit(3);
        iterateStream.forEach(System.out::println);

        Stream<Double> generateStream = Stream.generate(Math::random).limit(3);
        generateStream.forEach(System.out::println);
    }
}

