package com.jm;

public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread run!");
    }

    public static void main(String[] args) {
        (new Thread(new RunnableImpl())).start();
    }
}
