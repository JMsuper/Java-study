package test;

public class Cow implements Animal{
    @Override
    public void eat() {
        System.out.println("Eat grass!");
    }

    public void talk(){
        System.out.println("I'm cow!");
    }
}
