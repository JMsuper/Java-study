package com.jm.test;

public class MyClass<X> {
    <T> MyClass(T t){

    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass<Integer>("");
    }
}
