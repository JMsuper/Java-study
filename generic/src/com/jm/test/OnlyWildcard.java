package com.jm.test;

import java.util.ArrayList;
import java.util.List;

public class OnlyWildcard {

    public static void main(String[] args) {
        List<List<?>> listOfAnyList = new ArrayList<>();
        listOfAnyList.add(new ArrayList<String>());
        listOfAnyList.add(new ArrayList<Double>());

        ListOfAnyClassWithGeneric listOfAnyList2 = new ListOfAnyClassWithGeneric();
        listOfAnyList2.addList(new ArrayList<String>());
        listOfAnyList2.addList(new ArrayList<Double>());
    }
}

class ListOfAnyClassWithGeneric{
    List<Object> list = new ArrayList<>();
    public <T extends List> void addList(T t){
        list.add(t);
    }
}
