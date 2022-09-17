package com.jm.whyuseenum;

public enum SeasonWithValue {
    SPRING(0,"fresh"),
    SUMMER(1,"hot"),
    AUTUMN(2,"warm"),
    WINTER(3,"cold");

    final int value;
    final String weather;

    SeasonWithValue(int value, String weather){
        this.value = value;
        this.weather = weather;
    }

    public int getValue() {
        return value;
    }

    public String getWeather() {
        return weather;
    }
}
