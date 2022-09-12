package test;

public interface TestInterface extends ParentInterface1, ParentInterface2{
    void childInterfaceMethod();

    static void hello(){
        System.out.println("hello");
    }
}
