package com.jm.method.example;

// Main Thread's priority : 5
// child Thread1's priority : 1
// child Thread2's priority : 10
public class PriorityTest {
    public static void main(String[] args) throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        Thread childThread1 = new ChildThread(currentThread,"child thread 1");
        Thread childThread2 = new ChildThread(currentThread,"child thread 2");

        childThread1.setPriority(1);
        childThread2.setPriority(10);

        childThread1.start();
        childThread2.start();
        currentThread.sleep(4000);

    }
}


class ChildThread extends Thread{
    private Thread parentThread;
    private String name;

    ChildThread(Thread parentThread, String name){
        this.parentThread = parentThread;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " start!");
            sleep(1000);
            parentThread.join();
            System.out.println(name + " end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
