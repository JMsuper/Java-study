package com.example;

import java.util.function.Function;

public class EX2_function_pkg {
    public static void main(String[] args) {
        Function<String, String> fn = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "Function";
            }
        };

        System.out.println(fn.apply("EX2"));
    }
}
