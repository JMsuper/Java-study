package com.jm.geeksforgeeks;


class DeprecatedTest{
    @Deprecated
    public void Display(){
        System.out.println("Deprecatedtest display()");
    }
}
public class SurpressWarnningTest {
//    @SuppressWarnings({"checked","deprecation"})
    public static void main(String[] args) {
        DeprecatedTest deprecatedTest = new DeprecatedTest();
        deprecatedTest.Display();
    }
}
