package com.wistron.set;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

//Set集合德测试类
public class SetTest {

    @Test
    public void testHashSet(){
        Student stu1 = new Student(1, "chaojun1", "f");
        Student stu2 = new Student(1, "chaojun1", "f");
        Student stu3 = new Student(2, "chaojun2", "m");
        Student stu4 = new Student(3, "chaojun3", "f");
        Student stu5 = new Student(4, "chaojun4", "m");
        Student stu6 = new Student(5, "chaojun5", "f");

        HashSet<Student> hashSet = new HashSet<>(9);
        hashSet.add(stu1);
//        hashSet.add(stu2);
        hashSet.add(stu3);
        hashSet.add(stu4);
        hashSet.add(stu1);
        hashSet.add(stu5);
        hashSet.add(stu6);
        System.out.println(hashSet.size());
    }
}

class Student{
    private int number;
    private String Name;
    private String sex;

    public Student(int number, String name, String sex) {
        this.number = number;
        Name = name;
        this.sex = sex;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals方法被调用");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number && Objects.equals(Name, student.Name) && Objects.equals(sex, student.sex);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode方法被调用");
        return Objects.hash(number, Name, sex);
    }
}
