package com.example;

public class EX1{
    public static void main(String[] args) {
        // 람다식을 사용하지 않을 경우
        int width = 10;

        Drawable d = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Drawing " + width);
            }
        };
        d.draw();

        // 람다식을 사용할 경우
        Drawable d2 = ()-> System.out.println("Drawing " + width);
        d2.draw();
    }
}

interface Drawable{
    public void draw();
}
