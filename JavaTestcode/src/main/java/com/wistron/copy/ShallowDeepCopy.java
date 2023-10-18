package com.wistron.copy;

import java.util.Objects;

// Java 浅copy和深copy
public class ShallowDeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("江苏省", "苏州市");
        Person person = new Person(1, "Chaojun", address);
        Person pClone = (Person) person.clone();
        System.out.println(person);
        System.out.println(pClone);
        person.getAddress().setProvince("河南");
        System.out.println("-----------------------------");
        System.out.println(person);
        System.out.println(pClone);


    }
}

class Person implements Cloneable{
    private int id;
    private String name;
    private Address address;

    public Person(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person pClone = (Person) super.clone();
        pClone.address = (Address) pClone.address.clone();
        return pClone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address implements Cloneable{
    private String province;
    private String city;

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
