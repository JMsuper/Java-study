package com.jm.test;

public class GenericMethodBounded {
    public static void boxTest(Box<Number> n){
        System.out.println(n.getT().getClass().getName());
    }

    public static void main(String[] args) {
//        Box<Integer> integerBox = new Box<>(123);
        ChildBox<String> childBox = new ChildBox<>("String");
//        boxTest(integerBox);
//        boxTest(childBox);

        System.out.println(childBox.getT2().getClass().getName());
        System.out.println(childBox.getT().getClass().getName());
    }
}


class ChildBox<T> extends Box<T>{
    private T t2;

    public T getT2() {
        return t2;
    }

    public ChildBox(T t2) {
        super(t2);
        this.t2 = t2;
    }
}

class Box<T>{
    private T t;
    public Box(T t){
        this.t = t;
    }
    public T getT() {
        return t;
    }
}
