package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class EX3_builtin_func {
    public static void main(String[] args) {
//        Consumer<StringBuilder> print = (value) -> System.out.println(value.toString());
//        Consumer<StringBuilder> addString = (value) -> value.append(" world");
//        addString.andThen(print).accept(new StringBuilder("hello"));

//        predicateEx();
//        functionEx();
        supplierEx();
    }

    static void predicateEx(){
        Predicate<Integer> predicate = (value) -> value >0;
        List<Integer> list = Arrays.asList(-2,-1, 0, 1, 2);
        list.stream().filter(predicate).forEach((value)-> System.out.println(value));
    }

    static void functionEx(){
        Function<String, String> function = (value) -> value + " addValue";
        System.out.println(function.apply("Default String"));
    }

    static void supplierEx(){
        Supplier<String> supplierStr = () -> "supply String!";
        System.out.println(supplierStr.get());
    }
}
