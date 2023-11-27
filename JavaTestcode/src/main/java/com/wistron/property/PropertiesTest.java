package com.wistron.property;

import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

    //测试Properties API
    @Test
    public void testPropertiesAPI() throws IOException {
//        Properties properties = new Properties();
//        //存值
//        properties.setProperty("001", "qinchao1");
//        properties.setProperty("002", "qinchao2");
//        properties.setProperty("003", "qinchao3");

        //取值
//        String name = properties.getProperty("001");
//        System.out.println(name);

        //遍历值
//        Set<String> name = properties.stringPropertyNames();
//        for(String x : name){
//            System.out.println(x);
//        }

        //存储值， 存储成key=value的值
//        FileWriter fw = new FileWriter("PropertiesTest1.properties");
//        properties.store(fw, "Create by us");
        //加载值, 加载key=value的值
//        FileReader fr = new FileReader("PropertiesTest.properties");
//        Properties properties2 = new Properties();
//        properties2.load(fr);
//        System.out.println( properties2.get("001"));


        //存储值， 存储成xml格式
//        FileOutputStream fos = new FileOutputStream("PropertiesTest2.properties");
//        properties.storeToXML(fos, "Create by us");
        //加载值, 加载xml的值
//        FileInputStream fis = new FileInputStream("PropertiesTest.properties");
//        Properties properties2 = new Properties();
//        properties2.loadFromXML(fis);
//        System.out.println(properties2.get("001"));

        //实验一个Properties对象不能同时加载key=value数据和xml数据
        Properties properties2 = new Properties();
        FileReader fr = new FileReader("PropertiesTest1.properties");
        properties2.load(fr);
        FileInputStream fis = new FileInputStream("PropertiesTest2.properties");
        properties2.loadFromXML(fis);
        Set<String> names = properties2.stringPropertyNames();
        for(String name : names){
            System.out.println(name+"==="+properties2.get(name));
        }
    }
}
