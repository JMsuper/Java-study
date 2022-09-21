package com.jm.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlockingIOTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader =
                new InputStreamReader(System.in);
        System.out.println(inputStreamReader.read());

        System.out.println("finished!");
    }
}



