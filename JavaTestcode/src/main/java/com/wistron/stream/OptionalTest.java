package com.wistron.stream;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        //Optinal对象创建的三种方式
        //第一种
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        //第二种
        Optional<Person> person = Optional.of(new Person(1, "chaojun"));
        System.out.println(person);

        //第三种
        Optional<Object> o1 = Optional.ofNullable(null);
        Optional<Object> o2 = Optional.ofNullable(new Person(1, "chaojun"));
    }

}

class Person{
    private int number;
    private String name;

    public Person(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
