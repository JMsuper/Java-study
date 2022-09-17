package com.jm.whyuseenum;

public class EnumValueTest {
    public static void main(String[] args) {
        SeasonWithValue seasonWithValue = SeasonWithValue.SUMMER;
        System.out.println(seasonWithValue.getValue());
        System.out.println(seasonWithValue.getWeather());

        System.out.println(seasonWithValue.value == 1);
        System.out.println(seasonWithValue.getWeather() == "hot");
    }
}
