package com.jm.method.example;

public class InterruptTest{
    public static void main(String[] args) {
        Thread thisThread = Thread.currentThread();
        InterruptedThread interruptTest = new InterruptedThread();
        interruptTest.start();
        InterruptThread interruptThread = new InterruptThread(interruptTest);
        interruptThread.start();
        System.out.println("main is finished!");
    }
}

class InterruptedThread extends Thread{
    @Override
    public void run() {
        try{
            Thread.sleep(4000);
            boolean isInterrupted = Thread.interrupted();
            System.out.println("Is interrupted? " + isInterrupted);
            System.out.println("This Thread is finished!");
        } catch (InterruptedException e) {
            System.out.println("Interrupt occur!");
            return;
        }
    }
}

class InterruptThread extends Thread{
    Thread otherThread;
    InterruptThread(Thread thread){
        this.otherThread = thread;
    }
    @Override
    public void run() {
        interruptOtherThread(otherThread);
    }
    public void interruptOtherThread(Thread thread){
        try {
            thread.interrupt();
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
}
