package example;

import example.ListOfNumbers;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TryWithResourcesTest tryWithResourcesTest = new TryWithResourcesTest();
        String path = "C:\\Users\\A\\Desktop\\study\\java_study\\exception_test\\src\\example\\test.txt";
        try {
            String result = tryWithResourcesTest.test(path);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
