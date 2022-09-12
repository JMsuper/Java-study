package test;

public class Main {
    public static void main(String[] args) {
        TestInterface testInterface = new TestImplement();
        testInterface.childInterfaceMethod();
        testInterface.parentInterfaceMethod();
        TestInterface.hello();

        ParentInterface1 parentInterface1 = new TestImplement();
        parentInterface1.parentInterfaceMethod();
//        parentInterface1.childInterfaceMethod();
    }
}
