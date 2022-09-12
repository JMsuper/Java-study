package test;

public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("Eat fish!");
    }

    public void talk(){
        System.out.println("I'm Cat!");
    }
}
