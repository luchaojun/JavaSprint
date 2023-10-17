package com.wistron.gson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.List;

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
        String str = "[\"张三\",\"李四\",\"王五\"]";
        TypeToken<List<String>> type = new TypeToken<List<String>>(){};
//        System.out.println(list);
    }
}
