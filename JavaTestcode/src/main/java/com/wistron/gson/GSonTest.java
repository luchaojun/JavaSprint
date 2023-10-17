package com.wistron.gson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class GSonTest {
    public static void main(String[] args) {
        //JSon对象的创建
//        JsonObject info = new JsonObject();
//        info.addProperty("name", "张三");
//        info.addProperty("age", "18");
//        info.addProperty("地理", 70);
//        info.addProperty("英语", 60);
//        System.out.println(info);

        //Json数组的创建
//        JsonObject info1 = new JsonObject();
//        info1.addProperty("name", "张三");
//        info1.addProperty("age", "18");
//        JsonObject info2 = new JsonObject();
//        info2.addProperty("name", "李四");
//        info2.addProperty("age", "19");
//        JsonArray array = new JsonArray();
//        array.add(info1);
//        array.add(info2);
//        System.out.println(array);

        //Json对象的取值
//        JsonArray array = new JsonArray();
//        array.add("1班");
//        array.add("2班");
//        array.add("3班");
//        JsonObject school = new JsonObject();
//        school.addProperty("schoolName", "第一中学");
//        school.addProperty("teacher", "刘梅");
//        JsonObject info = new JsonObject();
//        info.addProperty("name", "张三");
//        info.addProperty("age", 18);
//        info.add("gradle",array);
//        info.add("schoolInfo",school);
//        //获取单个属性
//        String name = info.get("name").getAsString();
//        System.out.println("name="+name);
//        //获取JsonArray
//        JsonArray gradle = info.getAsJsonArray("gradle");
//        System.out.println(gradle);
//        //获取JsonObject
//        JsonObject schoolInfo = info.getAsJsonObject("schoolInfo");
//        System.out.println(schoolInfo);

        //遍历Json数据
//        JsonObject info1 = new JsonObject();
//        info1.addProperty("name", "张三");
//        info1.addProperty("age", 18);
//        JsonObject info2 = new JsonObject();
//        info2.addProperty("name", "李四");
//        info2.addProperty("age", 19);
//        JsonArray array = new JsonArray();
//        array.add(info1);
//        array.add(info2);
//        for (JsonElement j : array){
//            JsonObject jobject = (JsonObject) j;
//            System.out.println(jobject.get("name").getAsString());
//        }
//        JsonArray array = new JsonArray();
//        array.add("张三");
//        array.add("李四");
//        array.add("王五");
//        for (JsonElement datum : array) {
//            String name = datum.getAsString();
//            System.out.println(name);
//        }

        //Json对象与字符串的转换
//        JsonObject info = new JsonObject();
//        info.addProperty("name", "张三");
//        info.addProperty("age", "18");
//        info.addProperty("地理", 70);
//        info.addProperty("英语", 60);
//        String str = info.toString();
//        JsonObject jo = JsonParser.parseString(str).getAsJsonObject();
//        System.out.println(jo.get("name").getAsString());

//        String str = "[\"张三\",\"李四\",\"王五\"]";
//        //json字符串转json数组
//        JsonArray data = JsonParser.parseString(str).getAsJsonArray();
//        //json数组转json字符串
//        String strData = data.toString();
//        System.out.println(strData);

        //json字符串数组转数组
//        String str = "[\"张三\",\"李四\",\"王五\"]";
//        Gson gson = new Gson();
//        String[] strArray = gson.fromJson(str, String[].class);
//        System.out.println(strArray[1]);

        //json字符串数组转List
//        String str = "[\"张三\",\"李四\",\"王五\"]";
//        TypeToken<List<String>> type = new TypeToken<List<String>>(){};
//        Gson gson = new Gson();
//        List<String> strs = gson.fromJson(str, type);
//        System.out.println(strs);

        //json字符串与java对象的转换
//        Student student = new Student(1, "chaojun");
//        Gson gson = new Gson();
//        String stuJson = gson.toJson(student);
//        System.out.println(stuJson);
//        Student student1 = gson.fromJson(stuJson, Student.class);
//        System.out.println(student1);

        // json字符串与Map转换
//        String str="{\n" +
//                "\"gradle\":\"高一\",\n" +
//                "\"number\":\"2\",\n" +
//                "\"people\":[{\"name\":\"张三\",\"age\":\"15\",\"phone\":\"123456\"},\n" +
//                "         {\"name\":\"李四\",\"age\":\"16\",\"phone\":\"78945\"}]\n" +
//                "}";
//        Gson gson = new Gson();
//        TypeToken<Map<String, Object>> mapType = new TypeToken<Map<String, Object>>(){};
//        Map<String, Object> map = gson.fromJson(str, mapType);
//        System.out.println(map.get("gradle").toString());
//        System.out.println(map.get("number").toString());
//        System.out.println(map.get("people").toString());
    }
}

class Student{
    private int number;
    private String name;

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
