package com.jm.synchronization;

public class ThreadInterference {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread incrementThread = new CounterThread(counter,"increment");
        Thread decrementThread = new CounterThread(counter,"decrement");

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();
        System.out.println(counter.value());
    }
}

class CounterThread extends Thread{
    Counter counter;
    String methodName;

    CounterThread(Counter counter, String methodName){
        this.counter = counter;
        this.methodName = methodName;
    }

    @Override
    public void run() {
        if(methodName == "increment") for (int i = 0; i < 1000000; i++) counter.increment();
        else for (int i = 0; i < 1000000; i++) counter.decrement();
    }
}
