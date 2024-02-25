package com.wistron.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/2/24 8:36
 * @Function： 使用单例模式获取SqlSession对象,  消除冗余代码
 */
public class MyBatisUtils {
    private static SqlSessionFactory factory = null;
    private static Logger mLoger;
    static{
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if(factory != null){
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }

    public static void closeSession(SqlSession session){
        if(session != null){
            session.close();
        }
    }
}
