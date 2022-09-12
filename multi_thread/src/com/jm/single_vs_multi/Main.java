package com.jm.single_vs_multi;

public class Main {
    public static void main(String[] args) {
        SingleThread singleThread = new SingleThread();
        MultiThread multiThread1 = new MultiThread();
        MultiThread multiThread2 = new MultiThread();

        singleThread.run();
        multiThread1.run();
        multiThread2.run();
    }
}
