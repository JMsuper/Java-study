package com.jm.test;

public class Util {
    public <K, V> void test(K key, V value){
        System.out.println(key);
        System.out.println(value);
    }

    public static void main(String[] args) {
        Util util = new Util();
        util.test("",123);
    }
}

class Pair<K, V>{
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

