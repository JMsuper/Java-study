package com.jm.test;

public class BoxMain {
    public static void main(String[] args) {
        int value = 10;

        BoxObject boxObject = new BoxObject();
        boxObject.setElement(value);
        String object = (String) boxObject.getElement();

        BoxGeneric<Integer> boxGeneric = new BoxGeneric<>();
        boxGeneric.setElement(value);
    }
}
