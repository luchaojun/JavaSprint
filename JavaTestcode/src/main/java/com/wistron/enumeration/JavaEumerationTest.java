package com.wistron.enumeration;

import org.junit.Test;

import java.util.Arrays;

import static com.wistron.enumeration.EnumColor.*;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/3/11 11:14
 * @Function： 测试枚举的代码
 */

//简单枚举类
enum DateEnum{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

//带有构造器和方法的构造器
enum DateEnumConstructorMethod{
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");

    private String desc;
    private DateEnumConstructorMethod(String desc){
        System.out.println("构造器被调用");
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        System.out.println("toString被调用");
        return name() + ":" +desc;
    }
}

//枚举抽象类
enum EnumAbstract{
    FIRST {
        @Override
        public String getInfo() {
            return  "First Time";
        }
    },

    SECOND {
        @Override
        public String getInfo() {
            return "Second Time";
        }
    };

    public abstract String getInfo();
}

//枚举接口
interface Food{
    String eat();
}
interface Sport{
    String run();
}

enum EnumInterface implements Food, Sport{
    ME("牛肉", "篮球"),
    YOU("猪肉", "乒乓球");

    private String food;
    private String sport;
    private EnumInterface(String food, String sport){
        this.food = food;
        this.sport = sport;
    }

    @Override
    public String eat() {
        return name() +" eat " + food;
    }

    @Override
    public String run() {
        return name() +" run " + sport;
    }
}

enum EnumColor{
    RED,
    GREEN,
    BLUE
}

public class JavaEumerationTest {
    public static void test(){

    }
    //测试简单的枚举方法
    @Test
    public void testDateEnum() {
        DateEnum sunday = DateEnum.SUNDAY;
        System.out.println("SUNDAY="+sunday);
        System.out.println(sunday.ordinal());

        DateEnum firday = DateEnum.FRIDAY;
        System.out.println("SUNDAY="+firday);
        System.out.println(sunday.compareTo(firday));

        DateEnum[] values = DateEnum.values();
        System.out.println(Arrays.toString(values));

        DateEnum s = DateEnum.valueOf("SUNDAY");
        System.out.println(s==sunday);

        DateEnum sunday1 = DateEnum.valueOf(DateEnum.class, "SUNDAY");
        System.out.println(s==sunday1);
    }

    //测试带有构造器和方法的枚举类型
    @Test
    public void testEnumConstructorMethod() {
        DateEnumConstructorMethod[] values = DateEnumConstructorMethod.values();
        for (DateEnumConstructorMethod value : values){
            System.out.println(value);
        }
    }

    //测试枚举抽象类
    @Test
    public void testEnumAbstract(){
        EnumAbstract[] values = EnumAbstract.values();
        for (EnumAbstract value : values){
            System.out.println(value.getInfo());
        }
    }

    //测试枚举接口
    @Test
    public void testEnumInterface(){
        EnumInterface[] values = EnumInterface.values();
        for (EnumInterface value : values){
            System.out.println(value.eat() + "---" + value.run());
        }
    }

    @Test
    public void testEnumSwitch(){
        EnumColor color = RED;
        switch (color){
            case RED:
                System.out.println("RED Color");
                break;
            case GREEN:
                System.out.println("GREEN Color");
                break;
            case BLUE:
                System.out.println("BLUE Color");
                break;
            default:
                break;
        }
    }
}
