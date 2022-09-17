package com.jm.enumset;

import java.util.EnumSet;

public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet enumSet1 = EnumSet.allOf(Color.class);
        print(enumSet1);

        EnumSet enumSet2 = EnumSet.noneOf(Color.class);
        print(enumSet2);

        EnumSet enumSet3 = EnumSet.of(Color.BLUE,Color.WHITE);
        print(enumSet3);

        EnumSet enumSet4 = EnumSet.range(Color.YELLOW,Color.BLACK);
        print(enumSet4);

        EnumSet enumSet5 = EnumSet.complementOf(EnumSet.of(Color.BLUE,Color.BLACK));
        print(enumSet5);

        EnumSet enumSet6 = EnumSet.copyOf(EnumSet.of(Color.BLUE,Color.BLACK));
        print(enumSet6);

        EnumSet enumSet7 = EnumSet.noneOf(Color.class);
        enumSet7.add(Color.RED);
        enumSet7.add(Color.BLUE);
        print(enumSet7);

        System.out.println("Set contain RED? " + enumSet7.contains(Color.RED));
        enumSet7.forEach(System.out::print);
        enumSet7.remove(Color.RED);
        System.out.println();
        enumSet7.forEach(System.out::print);
    }

    private static void print(EnumSet enumSet){
        for(Object item : enumSet.toArray()) System.out.print(item + " ");
        System.out.println();
    }

    public enum Color{
        RED,YELLOW,GREEN,BLUE,BLACK,WHITE
    }
}
