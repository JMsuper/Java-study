package test;

public class TestImplement implements TestInterface {
    @Override
    public void parentInterfaceMethod() {
        System.out.println("Parent Interface Method");
    }

    @Override
    public void childInterfaceMethod() {
        System.out.println("Child Interface Method");
    }
}
