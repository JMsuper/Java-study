package com.jm.test;

public class OverrideTest {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        ParentClass parentClass = childClass;
        parentClass.parentMethod();
    }
}

class ParentClass{
    public void parentMethod(){
        System.out.println("parentMethod!");
    }
}

class ChildClass extends ParentClass{
    public void parentMethod(){
        System.out.println("childMethod!");
    }
}
