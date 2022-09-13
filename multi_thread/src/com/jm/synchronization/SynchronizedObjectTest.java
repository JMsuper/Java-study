package com.jm.synchronization;


// synchronized 키워드는, 메소드를 통해 동일한 객체를 접근하는 쓰레드들이
// 절차적으로 수행되도록 만든다고 이해하였다.
// 그렇다면, 메소드 상에서 해당 객체로 접근하는 코드가 아니면 정상 실행되고,
// 객체에 접근하는 코드일 때, 쓰레드의 상태는 BLOCKED로 변하는 것일까??

// 만약, 내 가정이 맞다면, "method front"가 동시에 두 줄에 출력되는 경우는 존재해야 한다.

// 결론 : 내 가정이 틀렸다. 객체로 접근하는 코드일 때만 블락되지 않고, 메소드 레벨에서 블락이 이뤄지고 있다.
public class SynchronizedObjectTest {
    public static void main(String[] args) {
        TestObject testObject = new TestObject();
        Thread thread1 = new ObjectTestThread(testObject);
        Thread thread2 = new ObjectTestThread(testObject);
        thread1.start();
        thread2.start();
    }
}

class ObjectTestThread extends Thread{
    TestObject testObject;

    ObjectTestThread(TestObject testObject){
        this.testObject = testObject;
    }

    @Override
    public void run() {
        testObject.test();
    }
}

class TestObject{
    int c = 0;
    public synchronized void test(){
        System.out.println("method front");

        for(int i = 0; i < 1000000; i++){
            for (int j = 0; j < 100000000; j++)  {
                c++;
            }
        }
        System.out.println(c);

        System.out.println("method back");
    }
}
