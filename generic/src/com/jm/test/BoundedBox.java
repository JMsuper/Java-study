package com.jm.test;

public class BoundedBox<T> {
    private T t;
    public void set(T t){
        this.t = t;
    }
    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
    public static void main(String[] args) {
        BoundedBox<Integer> boundedBox = new BoundedBox<>();
        boundedBox.set(10);
//        boundedBox.inspect("hello!");
    }
}
