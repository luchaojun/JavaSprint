package com.wistron.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/2/23 14:24
 * @Function：mysqltest.student数据库对应的对象类
 */
public class Student implements Serializable {
    private int id;
    private String name;

    private Date birth;
    private Date createAt;

    public Student(){}
    public Student(int id, String name, Date birth, Date createAt) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        System.out.println("getName被调用");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        System.out.println("getBirth被调用");
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", createAt=" + createAt +
                '}';
    }
}
