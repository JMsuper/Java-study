package com.jm;

public class ThreadInherit extends Thread{
    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        (new ThreadInherit()).start();
    }
}
