package com.example;

import java.util.function.Function;

public class EX4_lambda_use {
    public static void main(String[] args) {
        Calculate c1 = (a,b)-> a+b;
        Calculate c2 = (a,b) ->{return a+b;};
        Calculate c3 = Integer::sum;

        System.out.println(c1.calculate(10,20));
        System.out.println(c2.calculate(10,20));
        System.out.println(c3.calculate(10,20));
    }
}

interface Calculate{
    int calculate(int a, int b);
}


