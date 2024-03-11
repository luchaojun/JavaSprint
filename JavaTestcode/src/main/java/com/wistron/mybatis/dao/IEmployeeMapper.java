package com.wistron.mybatis.dao;

import com.wistron.mybatis.pojo.Employee;
import com.wistron.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/2/23 14:26
 * @Function： IStudentMapper.xml的接口
 */
public interface IEmployeeMapper {
    List<Employee> queryAllEmployee();
}
