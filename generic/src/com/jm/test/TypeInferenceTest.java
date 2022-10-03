package com.jm.test;

import java.io.Serializable;
import java.util.ArrayList;

public class TypeInferenceTest {
    public static <T> T pick(T a1, T a2){ return a2;}

    public static void main(String[] args) {
        Serializable s = pick("d",new ArrayList<String>());
    }
}
