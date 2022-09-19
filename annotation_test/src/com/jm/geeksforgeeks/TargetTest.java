package com.jm.geeksforgeeks;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassAnnotation{
    String value() default "Can annotate a class";
}

@Target({ElementType.METHOD,ElementType.TYPE,
        ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@interface MultipleElementTypeAnnotation{
    String value() default "Can annotate a class, method, annotation, or constructor";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldElementTypeAnnotation{
    String value() default "Can annotate a field";
}

@ClassAnnotation
public class TargetTest {

    @MultipleElementTypeAnnotation
    public void myMethod(){}

    // java: annotation type not applicable to this kind of declaration
    // @FieldElementTypeAnnotation
    // public void errorOccurMethod(){}

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        TargetTest targetTest = new TargetTest();

        Annotation a[] = targetTest.getClass().getAnnotations();

        System.out.println(a[0]);

        Class<?> className = Class.forName("com.jm.geeksforgeeks.TargetTest");
        Annotation b[] = className.getMethod("myMethod").getAnnotations();
        System.out.println(b[0]);
    }
}
