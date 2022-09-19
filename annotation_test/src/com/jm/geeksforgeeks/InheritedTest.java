package com.jm.geeksforgeeks;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface CustomAnnotation{
    String value();
}


@CustomAnnotation("hello!")
class ParentTestClass{}

public class InheritedTest extends ParentTestClass {
    public static void main(String[] args) {
        Class childClass = new InheritedTest().getClass();
        Annotation childAnnotation = childClass.getAnnotation(CustomAnnotation.class);
        Class parentClass = new ParentTestClass().getClass();
        Annotation parentAnnotation = parentClass.getAnnotation(CustomAnnotation.class);
        System.out.println(childAnnotation);
        System.out.println(parentAnnotation);
    }
}
