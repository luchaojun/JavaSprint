package com.wistron.mybatis.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/3/10 12:39
 * @Function：Employee Pojo对应数据库mysqltest-tb_emp
 */
public class Employee implements Serializable {
    private int id;
    private String username;
    private String password;
    private String name;
    private int gender;
    private String image;
    private int job;
    private Date entrydate;
    private int dept_id;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private Dept dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", image='" + image + '\'' +
                ", job=" + job +
                ", entrydate=" + entrydate +
                ", dept_id=" + dept_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", dept=" + dept +
                '}';
    }
}
