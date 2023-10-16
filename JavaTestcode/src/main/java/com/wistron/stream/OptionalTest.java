package com.wistron.stream;

import java.util.ArrayList;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        //Optinal对象创建的三种方式
        //第一种
//        Optional<Object> empty = Optional.empty();
//        System.out.println(empty);

        //第二种
//        Optional<Person> person = Optional.of(new Person(1, "chaojun"));
//        System.out.println(person);

        //第三种
//        Optional<Object> o1 = Optional.ofNullable(null);
//        Optional<Object> o2 = Optional.ofNullable(new Person(1, "chaojun"));

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        list.add(2);
//        Optional<ArrayList<Integer>> l = Optional.of(list);
//        //Opitional get() api
//        System.out.println(l.get());
//        //Opitional ifPresent() api
//        l.ifPresent(System.out::println);
//        //Opitional isPresent() api
//        System.out.println(l.isPresent());

        Name name = new Name("lu", "chaojun");
        Student s = new Student(1, name, "f");
        //判断对象的对象是否为空
        String n = Optional.ofNullable(s).map(Student::getName).map(Name::getFirstName).orElse("value is null");
        System.out.println(n);
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

class Student {
    private int number;
    private Name name;

    private String sex;

    public Student(int number, Name name, String sex) {
        this.number = number;
        this.name = name;
        this.sex = sex;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

class Name{
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
