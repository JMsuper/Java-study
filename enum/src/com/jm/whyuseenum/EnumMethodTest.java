package com.jm.whyuseenum;

public class EnumMethodTest {
    public static void main(String[] args) {
        Season season = Season.SUMMER;

        for (Season item : Season.values()){
            System.out.println(item);
        }


        System.out.println(Season.valueOf("SUMMER").getClass());

        System.out.println(season.compareTo(Season.AUTUMN));
        System.out.println(season.compareTo(Season.SUMMER));

        System.out.println(season.ordinal());

        System.out.println(season.name());
    }
}
