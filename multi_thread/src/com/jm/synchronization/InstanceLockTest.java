package com.jm.synchronization;


// 실험 : 모든 객체는 고유한 Lock을 가지고 있다고 공식문서는 말한다. 그렇다면, 하나의 객체에서 어느 메소드를 호출해서 사용중이면,
// 해당 객체의 다른 메소드를 다른 쓰레드가 호출할 수 없을까?
// 경우1 : 두 메소드 모두 synchronized method이다.
// 경우2 : 한 메소드는 synchronized method이고, 다른 메소드는 일반 메소드이다.

// 경우1 -> 결과 : 다른 쓰레드가 Block됨
// 경우2 -> 결과 : Block되지 않음

// 결과 : synchronized 키워드를 붙이면 해당 메소드의 객체의 고유한 Lock을 얻게 된다. 하지만, 해당 Lock은 synchronized 키워드가 붙여진
// 메소드에만 적용된다. 즉, 일반 메소드는 synchronized 메소드와 논외로 실행된다. synchronized method가 실행되더라도 일반 메소드는
// block되지 않는다. synchronized 키워드를 갖는 메소드만 block된다.
// 또한, 일반 메소드가 먼저 실행될 때, synchnozied 메소드도 block되지 않고 실행된다.
public class InstanceLockTest {
    public static void main(String[] args) {
        LockObject lockObject = new LockObject();
        Thread thread1 = new Thread1(lockObject);
        Thread thread2 = new Thread2(lockObject);

        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread{
    LockObject lockObject;

    Thread1(LockObject lockObject){
        this.lockObject = lockObject;
    }

    @Override
    public void run() {
        lockObject.synchronizedMethod1();
    }
}

class Thread2 extends Thread{
    LockObject lockObject;

    Thread2(LockObject lockObject){
        this.lockObject = lockObject;
    }

    @Override
    public void run() {
        lockObject.synchronizedMethod2();
    }
}


class LockObject{
    public synchronized void synchronizedMethod1(){
        System.out.println("synchronizedMethod1 start!");
        int c = 2;
        for (int i = 0; i < 1000000000;i++){
            for (int j = 0; j < 1000000000;j++){
                c = c * c;
            }
        }
        System.out.println("synchronizedMethod1 finished!");
    }

    public synchronized void synchronizedMethod2(){
        System.out.println("synchronizedMethod2 start!");
        int c = 2;
        for (int i = 0; i < 1000000000;i++){
            for (int j = 0; j < 1000000000;j++){
                c = c * c;
            }
        }
        System.out.println("synchronizedMethod2 finished!");
    }
}


