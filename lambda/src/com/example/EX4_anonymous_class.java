package com.example;

public class EX4_anonymous_class {

    public static Animal cat = new Animal(){
        @Override
        public void eat(){
            System.out.println("eat fish!");
        }
    };

    public static void main(String[] args) {
        cat.eat();
        Animal dog = new Animal(){
            @Override
            public void eat(){
                System.out.println("eat meat!");
            }
        };
        dog.eat();

        Bug bug = new Bug() {
            @Override
            public void eat() {
                System.out.println("eat bug!");
            }
        };
        bug.eat();
    }
}


class Animal{
    public void eat(){
        System.out.println("eat!");
    }
}

interface Bug{
    void eat();
}
