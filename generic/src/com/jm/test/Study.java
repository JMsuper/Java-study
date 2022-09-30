package com.jm.test;

public class Study {
    public <T> void method(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        Study study = new Study();
        study.method("Generic method call!");
    }
}
