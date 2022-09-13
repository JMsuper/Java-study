package com.jm.method.example;

// 메인 스레드가 종료될 때, 자식 스레드들도 자동으로 종료되는 지 확인합니다.
public class MainThreadStopTest {
    public static void main(String[] args) throws InterruptedException {
        Thread childThread = new ChildTestThread();
        childThread.run();
        Thread.currentThread().sleep(1000);
        return;
    }
}

class ChildTestThread extends Thread{
    @Override
    public void run() {
        for(int i = 0 ;i < 5; i++){
            System.out.println("child thread run! count " + i + "!");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
