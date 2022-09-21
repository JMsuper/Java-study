package com.jm.io;

import java.io.*;

public class BufferInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("text.txt");
        BufferedInputStream br = new BufferedInputStream(fileInputStream);
        int c = 1;
        while((c = br.read()) > 0) {
            System.out.print((char) c);
        }
    }
}
