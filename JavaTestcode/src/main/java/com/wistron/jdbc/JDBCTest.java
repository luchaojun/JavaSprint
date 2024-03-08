package com.wistron.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.*;


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
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltest", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tb_emp");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println("name="+name);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //测试主键回填
    @Test
    public void testJDBCGenerateKey(){
        try {
            //調用此包名下的靜態代碼塊
            Class.forName("com.mysql.cj.jdbc.Driver");
            //自己注冊驅動
//            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltest", "root", "root");
            PreparedStatement ps = connection.prepareStatement("insert into student(name, birth, createAt) values (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, "baobao");
            ps.setString(2, new java.util.Date().getTime()+"");
            ps.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            System.out.println(keys.getInt(1));
//            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
