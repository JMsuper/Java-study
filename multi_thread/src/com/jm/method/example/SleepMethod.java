package com.jm.method.example;

public class SleepMethod {
    public static void main(String[] args){
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1!");
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2!");
        });

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread!");
    }
}
