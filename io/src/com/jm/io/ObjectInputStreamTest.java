package com.jm.io;

import java.io.*;

public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException {
        String fileName = "object.txt";

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            Data data = new Data("JM");
            objectOutputStream.writeObject(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))){
            Data data2 = (Data) inputStream.readObject();
            System.out.println(data2.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Data implements Serializable{
    private String name;
    Data(String name) {this.name = name;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
