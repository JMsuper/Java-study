package com.jm.synchronization;

public class MemoryConsistencyErrorsTest {
    public static void main(String[] args) {
        IntWrapper intWrapper = new IntWrapper();
        Thread incrementThread = new IncrementThread(intWrapper);
        Thread readThread = new ReadThread(intWrapper,incrementThread);
        incrementThread.start();
        readThread.start();
    }
}

class IntWrapper{
    public int i = 0;
}

class IncrementThread extends Thread{
    IntWrapper intWrapper;

    IncrementThread(IntWrapper intWrapper){
        this.intWrapper = intWrapper;
    }

    @Override
    public void run() {
        intWrapper.i = intWrapper.i + 1;
    }
}

class ReadThread extends Thread{
    IntWrapper intWrapper;
    Thread incrementThread;

    ReadThread(IntWrapper intWrapper, Thread incrementThread){
        this.intWrapper = intWrapper;
        this.incrementThread = incrementThread;
    }

    @Override
    public void run() {
        System.out.println(intWrapper.i);
    }
}


