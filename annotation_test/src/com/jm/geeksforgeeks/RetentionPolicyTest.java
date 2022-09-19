package com.jm.geeksforgeeks;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@interface SourceRetention{
    String value() default "Source Retention";
}

@Retention(RetentionPolicy.CLASS)
@interface ClassRetention{
    String value() default "Class Retention";
}

@Retention(RetentionPolicy.RUNTIME)
@interface RuntimeRetention{
    String value() default "Runtime Retention";
}

@SourceRetention
class A{}

@ClassRetention
class B{}

@RuntimeRetention
class C{}

public class RetentionPolicyTest {
    public static void main(String[] args) {
        // Obtaining the array of annotations used to
        // annotate class A, B, and C. Array a and b will be
        // empty as their annotation are attached before
        // runtime while array c will contain the
        // RuntimeRetention annotation as it was marked with
        // RUNTIME retention policy
        Annotation a[] = new A().getClass().getAnnotations();
        Annotation b[] = new B().getClass().getAnnotations();
        Annotation c[] = new C().getClass().getAnnotations();

        // Printing the number of retained annotations of each class at runtime
        System.out.println("Number of annotations attached to class A at Runtime: " + a.length);
        System.out.println("Number of annotations attached to class B at Runtime: " + b.length);
        System.out.println("Number of annotations attached to class C at Runtime: " + c.length);

    }
}
