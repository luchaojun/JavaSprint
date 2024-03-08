package com.wistron.mybatis.dao;

import com.wistron.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/2/23 14:26
 * @Function： IStudentMapper.xml的接口
 */
public interface IStudentMapper {
    List<Student> queryStudent();

    void insertOneStudent();

    Student selectStudentById(@Param("xxx") int id);

    void updateStudent(Student student);

    void insertOneBySelectKey(Student student);
}
