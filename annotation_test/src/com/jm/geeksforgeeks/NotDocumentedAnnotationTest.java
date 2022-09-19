package com.jm.geeksforgeeks;

@interface NotDocumentedAnnotation{
    String value();
}

@NotDocumentedAnnotation("NotDocumentedAnnotationTest")
public class NotDocumentedAnnotationTest {
    public static void main(String[] args) {
        System.out.println("This is main method");
    }
}
