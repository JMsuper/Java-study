package com.jm.whyuseenum;

public class NotUseEnum {
    public static void main(String[] args) {
        // int 데이터를 통해 Color 나타내기
        String intColor = ColorInt.getType(1);

        // 객체를 통해 Color 나타내기
        ObjectColor objectColor = ObjectColor.RED;

        // enum을 통해 Color 나타내기
        Color enumColor = Color.BLUE;

//        switch (objectColor){
//
//        }
        switch (enumColor){

        }
    }
}


// 색 종류를 구별하기 위해 int 값을 사용한다.
// 1 : RED
// 2 : BLUE
// 3 : GREEN
// 사용자는 각 숫자가 어떤 값과 대응되는 지 알고 있어야 한다.
class ColorInt{
    static String getType(int type) throws IllegalArgumentException {
        if(type == 1){
            return "RED";
        }else if(type == 2){
            return "BLUE";
        }else if(type == 3){
            return "GREEN";
        }else{
            throw new IllegalArgumentException();
        }
    }
}

class ObjectColor{
    private ObjectColor(){}
    static final ObjectColor RED = new ObjectColor();
    static final ObjectColor BLUE = new ObjectColor();
    static final ObjectColor GREEN = new ObjectColor();
}

enum Color{RED, BLUE, GREEN}
