package com.jm.geeksforgeeks;


import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface Words{
    String word() default "Hello";
    int value() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos{
    Words[] value();
}

public class Main {

    @Words(word = "First", value = 1)
    @Words(word = "Second", value = 2)
    public static void newMethod() {
        Main obj = new Main();

        try{
            Class<?> c = obj.getClass();

            // Obtain the annotation for newMethod
            Method m = c.getMethod("newMethod");

            // Display the repeated annotation
            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        newMethod();
    }
}
