package com.jm.first;

public class Main {
    public static void main(String[] args) {
        Thread t = new ThreadTest();
        t.start();

        int cnt = 1;
        int multiple = 1;
        while(cnt <= 10){
            multiple *= cnt;
            System.out.println("main x"+cnt+"="+multiple);
            cnt++;
        }
    }
}
