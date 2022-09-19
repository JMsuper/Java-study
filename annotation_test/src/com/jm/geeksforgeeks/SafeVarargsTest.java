package com.jm.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

class Machine<T>{
    private List<T> versions = new ArrayList<>();

//    @SafeVarargs
    public final void safe(T... toAdd){
        for(T version : toAdd){
            versions.add(version);
        }
    }
}

public class SafeVarargsTest {
    public static void main(String[] args) {
        Machine machine = new Machine();
    }
}
