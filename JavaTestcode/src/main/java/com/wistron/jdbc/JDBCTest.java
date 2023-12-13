package com.wistron.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author：Chaojun_Lu
 * @Date：2023/12/12 22:46
 * @Function： JDBC Study
 */
public class JDBCTest {
    @Test
    public void testJDBCAPI(){
        //四個JDBC主要對象的入口
//        Connection connection = DriverManager.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery();

        try {
            //調用此包名下的靜態代碼塊
            Class.forName("com.mysql.cj.jdbc.Driver");
            //自己注冊驅動
//            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlstudy", "root", "1234567890");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println("name="+name);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
