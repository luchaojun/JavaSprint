package com.wistron.mybatis;

import com.wistron.mybatis.dao.IStudentMapper;
import com.wistron.mybatis.pojo.Student;
import com.wistron.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/2/23 13:46
 * @Function： 测试MyBatis的一些功能
 */
public class MybatisTest {
    @Test
    public void testMybatisConfigFile() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        System.out.println("sqlSession=" + sqlSession);
        MyBatisUtils.closeSession(sqlSession);
    }

    @Test
    public void testMybatisQueryData() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        List<Student> students = sqlSession.selectList("com.wistron.mybatis.dao.IStudentMapper.queryStudent");
        System.out.println(students.toString());
//        MyBatisUtils.closeSession(sqlSession);
    }
}
