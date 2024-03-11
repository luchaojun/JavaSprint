package com.wistron.mybatis.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/3/10 13:00
 * @Function：
 */
public class Dept implements Serializable {
    private int id;
    private String name;
    private LocalDateTime create_time;
    private LocalDateTime update_time;

    public Dept() {}

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

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
