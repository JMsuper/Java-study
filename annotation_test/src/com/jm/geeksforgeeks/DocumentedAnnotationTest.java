package com.jm.geeksforgeeks;

import java.lang.annotation.Documented;

@Documented
@interface DocumentedAnnotation{
    String value();
}

@DocumentedAnnotation("DocumentedAnnotationTest")
public class DocumentedAnnotationTest {
    public static void main(String[] args) {
        System.out.println("This is the main function");
    }
}
