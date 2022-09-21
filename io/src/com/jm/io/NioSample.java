package com.jm.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioSample {
    public static void main(String[] args) {
        NioSample nioSample = new NioSample();
        nioSample.basicWriteAndRead();
//        FilterInputStream
    }

    public void basicWriteAndRead(){
        String filename = "text.txt";
        try {
            writeFile(filename,"My first NIO sample");
            readFile(filename);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeFile(String filename, String data) throws IOException {
        // FileChannel 객체를 만들려면, FileOutputStream 클래스에 선언된 getChannel()을 호출한다.
        FileChannel channel = new FileOutputStream(filename).getChannel();
        byte[] byteData = data.getBytes();
        // ByteBuffer 클래스의 static 메소드인 wrap()을 호출하면 ByteBuffer 객체를 반환한다.
        // ByteBuffer는 abstract 클래스이기 때문에, 해당 클래스를 구현한 구현체의 인스턴스를
        // 리턴하는 것이다. 또한, Buffer객체가 필요한 이유는 Channel 클래스에서
        // Buffer객체를 이용해 대상과 데이터를 주고받기 때문이다.
        ByteBuffer buffer = ByteBuffer.wrap(byteData);
        // write()메소드에 buffer 객체를 넘겨주면 파일에 데이터를 쓰이게 된다.
        channel.write(buffer);
        channel.close();
    }

    public void readFile(String fileName) throws Exception{
        // writeFile() 메소드에서와 동일하게 File***Stream 객체로 부터 Channel 객체를 가져온다.
        FileChannel channel = new FileInputStream(fileName).getChannel();
        // Buffer 인스턴스를 생성하는 다른 방법이다.
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // read() 메소드에 buffer 객체를 넘겨주어 읽어드리기 위한 준비를 한다.
        channel.read(buffer);
        // buffer 객체는 CD와 같이 현재 위치를 가지고 있다.
        // flip()은 그러한 위치를 처음으로 옮기고, 버퍼가 읽거나 쓸 수 없는 첫 번째 위치를
        // 나타내는 limit을 맨 끝으로 이동시켜준다.
        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }
        channel.close();
    }
}
