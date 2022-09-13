package com.jm.synchronization;


// 공유하는 객체가 없는 경우에도 synchronized 키워드가 있으면 블락될까?
// 블락된다!

// synchronized 키워드가 있으면 공유되는 객체의 유무와는 상관없이 해당 메소드 레벨로 블락된다.
public class SynchronizedTestNoObject {
    public static void main(String[] args) {
        TestNoObject testNoObject = new TestNoObject();
        Thread thread1 = new NoObjectThread(testNoObject);
        Thread thread2 = new NoObjectThread(testNoObject);
        thread1.start();
        thread2.start();
    }
}

class NoObjectThread extends Thread{
    TestNoObject testNoObject;

    NoObjectThread(TestNoObject testNoObject){
        this.testNoObject = testNoObject;
    }

    @Override
    public void run() {
        testNoObject.test();
    }
}

class TestNoObject{
    public synchronized void test(){
        System.out.println("method start!");
        int c = 0;
        for (int i = 0; i < 10000000; i++){
            for(int j = 0; j < 1000; j++){
                c++;
            }
        }
        System.out.println(c);
        System.out.println("method end!");
    }
}
