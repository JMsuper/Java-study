package com.jm.whyuseenum;

public class EnumVariableTest {
    public static void main(String[] args) {
        Season season = null;
        season = Season.SUMMER;

        // String과 Enum을 "=="를 통해 비교할 수 없다.
        // System.out.println(season == "SUMMER");

        System.out.println(season == Season.valueOf("SUMMER"));

        System.out.println(season == Season.SUMMER);

        System.out.println(season.compareTo(Season.SPRING));


        // enum 상수는 내부적으로 int type 상수값을 갖고 있지만,
        // 자바에서 enum 상수와 int 타입간의 비교를 지원하지 않는다.
        // System.out.println(season == 1);
    }
}
