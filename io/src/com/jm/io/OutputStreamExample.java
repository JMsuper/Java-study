package com.jm.io;

import java.io.*;

public class OutputStreamExample {
    public static void main(String[] args) throws IOException {
        OutputStream output = new FileOutputStream("file.txt");
        byte b[] = {65,66,67,68,69,70};

        // illustrating write(nyte[] b) method
        // b 배열에서 요소 1개씩 write한다.
        output.write(b);
        // illustrating write(int b) method
        for(int i = 71; i < 75; i++){
            output.write(i);
        }
        output.close();
    }
}
