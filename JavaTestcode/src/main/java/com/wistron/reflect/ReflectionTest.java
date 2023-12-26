package com.wistron.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: Chaojun_Lu
 * @Date: 20231226 9:43
 * @Function: Test Reflect
 */
public class ReflectionTest {
    public static void main(String[] args) {
        Animal animal = new Dog();
//        Class<? extends Animal> animalClass = animal.getClass();
        //获取所有的方法包括父类, 父类的父类
//        for (Method method : animalClass.getMethods()) {
//            System.out.println(method.getName());
//        }

        //获取完整路径名
//        String name = animalClass.getName();
//        System.out.println("name="+name);

        //获取该类当中所有的内部类
        Dog dog = new Dog();
//        Class<?>[] classes = dog.getClass().getDeclaredClasses();
//        System.out.println("classes.length="+classes.length);
//        for (Class clazz : classes){
//            System.out.println("clazz="+clazz);
//        }

        //获取该类所有的方法包括私有方法
//        Method[] declaredMethods = dog.getClass().getDeclaredMethods();
//        for(Method method : declaredMethods){
//            System.out.println(method.getName());
//        }


//        //获取该类所有的属性包括私有属性
//        for (Field field : dog.getClass().getDeclaredFields()){
//            System.out.println(field.getName());
//        }

        //获取该父类所有的属性包括私有属性
        Class<?> dogSuper = dog.getClass().getSuperclass();
//        for (Field field : dogSuper.getDeclaredFields()){
//            System.out.println(field.getName());
//        }


        //判断是否为某各类的实例
        Animal animal1 = new Animal();
        Dog dog1 = new Dog();
//        System.out.println(dogSuper.isInstance(animal));
//        System.out.println(dogSuper.isInstance(dog1));

        //获取包名
//        System.out.println(dog1.getClass().getPackage().getName());

        //获取接口类
        Class<?>[] interfaces = dog1.getClass().getInterfaces();
        for (Class i : interfaces){
            System.out.println(i.getName());
        }
    }
}

interface Test1{

}

interface Test2{

}

class AnimalObj{
    private String AnimalObjPrivate;
    public String AnimalObjPublic;
    private void testUp(){
        System.out.println("testUp");
    }
}

class Animal extends AnimalObj{
    private String animalPrivate;
    public String animalPublic;
    public void testA(){
        System.out.println("TestA");
    }

    public void testB(){
        System.out.println("TestB");
    }
}

class Dog extends Animal implements Test1, Test2{
    private String dogPrivate;
    public String dogPublic;
    public void testC(){
        System.out.println("TestC");
    }

    private void testD(){
        System.out.println("TestD");
    }

    class Test{

    }
}
