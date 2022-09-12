package com.jm.method.example;

public class JoinTest extends Thread{
    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child Thread finished!");
    }

    public static void main(String[] args) {
        JoinTest joinTest = new JoinTest();
        joinTest.start();
        try {
            joinTest.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread finished!");
    }
}
