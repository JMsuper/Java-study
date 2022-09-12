package com.jm.first;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        int cnt = 1;
        int multiple = 1;
        while(cnt <= 10){
            multiple *= cnt;
            System.out.println("thread x"+cnt+"="+multiple);
            cnt++;
        }
    }
}
