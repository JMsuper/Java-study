package com.jm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBoundedTypeTest {
    public static void main(String[] args) {
        List list = new ArrayList(Arrays.asList(1,2,3,4,5));
        wildCard(list);
        normalMethod(list);
        boundedType(list);
    }

    public static void wildCard(List<? extends Number> list){
        for(Number n : list){
            System.out.println(n);
        }
    }

    public static void normalMethod(List<Number> list){
        for(Number n : list){
            System.out.println(n);
        }
    }

    public static <T extends Number> void boundedType(List<T> list){
        for(T t : list){
            System.out.println(t);
        }
    }
}
