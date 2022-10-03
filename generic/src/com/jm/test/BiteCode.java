package com.jm.test;

public class BiteCode <T>{
    private T t;
    public void setT(T t){
        this.t = t;
    }
    public T getT(){
        return t;
    }
    public static void main(String[] args) {
        BiteCode<Integer> biteCode = new BiteCode<>();
        biteCode.setT(10);
        Integer i = biteCode.getT();
    }
}
