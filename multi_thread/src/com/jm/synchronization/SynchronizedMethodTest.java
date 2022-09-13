package com.jm.synchronization;

public class SynchronizedMethodTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();
        Thread incrementThread = new SynchronizedCounterThread(counter,"increment");
        Thread decrementThread = new SynchronizedCounterThread(counter,"decrement");

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();
        System.out.println(counter.value());
    }
}

class SynchronizedCounterThread extends Thread{
    SynchronizedCounter counter;
    String methodName;

    SynchronizedCounterThread(SynchronizedCounter counter, String methodName){
        this.counter = counter;
        this.methodName = methodName;
    }

    @Override
    public void run() {
        if(methodName == "increment") for (int i = 0; i < 1000000; i++) counter.increment();
        else for (int i = 0; i < 1000000; i++) counter.decrement();
    }
}
