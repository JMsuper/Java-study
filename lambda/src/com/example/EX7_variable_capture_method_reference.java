package com.example;

import java.lang.invoke.CallSite;

public class EX7_variable_capture_method_reference {
    public static void main(String[] args) {
        TestInterface retInterface = TestClass.func2();
        retInterface.func(10);
        retInterface.func(10);
    }
}


class TestClass{
    int data = 10;

    public static TestInterface func2(){
        TestClass testClass = new TestClass();
        TestInterface testInterface = (n)-> {
            testClass.data += 10;
            System.out.println("Data : " + testClass.data);
        };
        testInterface.func(10);
        return testInterface;
    }
}

interface TestInterface{
    void func(int n);
}
