package com.jm.method.example;

public class StatusTest {
    public static void main(String[] args) throws InterruptedException {

        // state : NEW
        Thread newStateThread = new Thread(new NewStateThread());
        System.out.println("State : " + newStateThread.getState());

        // state : RUNNABLE
        newStateThread.start();
        System.out.println("State : " + newStateThread.getState());

        // state : TIME_WAITING
        Thread timeWaitingStateThread = new SleepThread();
        timeWaitingStateThread.start();
        timeWaitingStateThread.join(1000);
        System.out.println("State : " + timeWaitingStateThread.getState());

        // state : WAITING
        Thread waitStateThread = new WaitStateThread();
        waitStateThread.start();
        waitStateThread.join(1000);
        System.out.println("State : " + waitStateThread.getState());

        // state : TERMINATED
        Thread.currentThread().sleep(2000);
        System.out.println("State : " + timeWaitingStateThread.getState());

    }
}

class NewStateThread implements Runnable {
    @Override
    public void run() {
        for(int i = 0 ; i < 1000000; i++){
            for(int j = 0 ; j < 1000000; j++){}
        }
    }
}

class SleepThread extends Thread{
    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WaitStateThread extends Thread{
    @Override
    public void run() {
        Thread thread = new SleepThread();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
