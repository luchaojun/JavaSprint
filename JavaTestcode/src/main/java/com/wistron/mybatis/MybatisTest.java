package com.wistron.mybatis;

import com.wistron.mybatis.dao.IEmployeeMapper;
import com.wistron.mybatis.dao.IStudentMapper;
import com.wistron.mybatis.pojo.Employee;
import com.wistron.mybatis.pojo.Student;
import com.wistron.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/2/23 13:46
 * @Function： 测试MyBatis的一些功能
 */
public class MybatisTest {
    private static Logger mLog = LogManager.getLogger(MybatisTest.class);
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
        mLog.info(students);
        MyBatisUtils.closeSession(sqlSession);
    }

    @Test
    public void testInsertOneStudent() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Student student = new Student();
        student.setName("Chaojun1");
        student.setBirth(new Date());
        student.setCreateAt(new Date());
        sqlSession.insert("com.wistron.mybatis.dao.IStudentMapper.insertOneStudent", student);
        sqlSession.commit();
        MyBatisUtils.closeSession(sqlSession);
        mLog.info("student="+student);
    }

    @Test
    public void testSelectStudentById() throws IOException {
//        //一级缓存测试代码
//        SqlSession sqlSession = MyBatisUtils.getSingleSqlSession();
//        mLog.info("sqlSession1="+sqlSession);
////        Student student = (Student) sqlSession.selectOne("com.wistron.mybatis.dao.IStudentMapper.selectStudentById", 2);
//        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
//        Student student = mapper.selectStudentById(2);
//        mLog.info(student);
//        mapper.updateStudent(new Student(2, "qinchao", new Date(), new Date()));
//        sqlSession.commit();
//        System.out.println("====================================");
//        SqlSession sqlSession2 = MyBatisUtils.getSingleSqlSession();
//        IStudentMapper mapper2 = sqlSession2.getMapper(IStudentMapper.class);
//        mLog.info("sqlSession2="+sqlSession2);
////        Student student2 = (Student) sqlSession2.selectOne("com.wistron.mybatis.dao.IStudentMapper.selectStudentById", 2);
//        Student student2 = mapper2.selectStudentById(2);
//        mLog.info(student2);
//        mLog.info("student == student2 ---"+(student == student2));
//        MyBatisUtils.closeSession(sqlSession2);

        //二级缓存测试代码
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        mLog.info("sqlSession1="+sqlSession);
//        Student student = (Student) sqlSession.selectOne("com.wistron.mybatis.dao.IStudentMapper.selectStudentById", 2);
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        Student student = mapper.selectStudentById(2);
        mLog.info(student);
        mapper.updateStudent(new Student(2, "qinchao", new Date(), new Date()));
//        mapper.updateStudent(new Student(2, "qinchao", new Date(), new Date()));
        MyBatisUtils.closeSession(sqlSession);
//        System.out.println("====================================");
//        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();
//        IStudentMapper mapper2 = sqlSession2.getMapper(IStudentMapper.class);
//        mLog.info("sqlSession2="+sqlSession2);
////        Student student2 = (Student) sqlSession2.selectOne("com.wistron.mybatis.dao.IStudentMapper.selectStudentById", 2);
//        Student student2 = mapper2.selectStudentById(2);
//        mLog.info(student2);
//        mLog.info("student == student2 ---"+(student == student2));  //Student需要实现序列化接口, 二级缓存的对象不一样以为是序列化和反序列化的结果
//        MyBatisUtils.closeSession(sqlSession2);
    }

    //测试<selectKey>标签的使用
    @Test
    public void testInsertOneBySelectKey(){
        SqlSession sqlSession = MyBatisUtils.getSingleSqlSession();
//        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
//        mapper.insertOneBySelectKey();
        Student student = new Student();
        student.setName("Chaojun3");
        student.setBirth(new Date());
        student.setCreateAt(new Date());
        sqlSession.insert("com.wistron.mybatis.dao.IStudentMapper.insertOneBySelectKey", student);
        sqlSession.commit();
        mLog.info(student);
        MyBatisUtils.closeSession(sqlSession);
    }

    @Test
    //测试resultMap标签下面的constructor
    public void testResultMapConstructor(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        IStudentMapper iStudentMapper = sqlSession.getMapper(IStudentMapper.class);
        List<Student> students = iStudentMapper.queryStudent();
        mLog.info(students);
        MyBatisUtils.closeSession(sqlSession);
    }

    @Test
    //测试resultMap标签下面的constructor
    public void testResultMapAssociation(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        IEmployeeMapper iEmployeeMapper = sqlSession.getMapper(IEmployeeMapper.class);
        List<Employee> employees = iEmployeeMapper.queryAllEmployee();
        mLog.info(employees);
        MyBatisUtils.closeSession(sqlSession);
    }
}
