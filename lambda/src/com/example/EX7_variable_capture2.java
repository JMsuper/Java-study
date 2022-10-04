package com.example;

public class EX7_variable_capture2 {

    int data = 170;

    public static void main(String[] args) {
        EX7_variable_capture2 test  = new EX7_variable_capture2();

        MyInterface myInterface = ()->{
            System.out.println("Data : " + test.data);
            test.data += 500;
            System.out.println("Data : " + test.data);
        };

        myInterface.myFunction();
        test.data += 200;
        System.out.println("Data : " + test.data);
    }
}

interface MyInterface{
    void myFunction();
}
