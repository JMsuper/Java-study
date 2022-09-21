package com.jm.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("file.txt");
        int c = 1;
        while( (c = fileInputStream.read()) > 0){
            System.out.print((char) c);
        }
        fileInputStream.close();
    }
}
