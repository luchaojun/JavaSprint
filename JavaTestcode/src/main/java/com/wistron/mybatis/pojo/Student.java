package com.wistron.mybatis.pojo;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/2/23 14:24
 * @Function：mysqltest.student数据库对应的对象类
 */
public class Student {
    private int id;
    private String name;

    public Student(){}
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
