package com.example;

public class EX6_variable_capture {
    public static void main(String[] args) {
        int number = 10;

        MyFunction myLambda = (n)->{
            int value = number + n;
            return value;
        };
//        number = 9;
//        number = myLambda.func(10);
        System.out.println(number);

    }
}

interface MyFunction{
    int func(int n);
}
