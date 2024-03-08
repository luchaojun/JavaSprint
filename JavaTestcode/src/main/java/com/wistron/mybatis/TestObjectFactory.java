package com.wistron.mybatis;

import com.wistron.mybatis.pojo.Student;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/3/1 0:45
 * @Function：  查询数据库返回数据的时候调用create方法
 */
public class TestObjectFactory extends DefaultObjectFactory{
    private static Logger mLog = LogManager.getLogger(MybatisTest.class);
    @Override
    public void setProperties(Properties properties) {
        mLog.info("Properties="+properties.getProperty("luchaojun"));
        super.setProperties(properties);
    }

    @Override
    public <T> T create(Class<T> type) {
        mLog.info("create Method="+type);
        if(type.equals(Student.class)){
            Student student = (Student) super.create(type);
            student.setCreateAt(new Date());
            return (T)student;
        }
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
