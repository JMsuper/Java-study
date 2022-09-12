package example;

import java.io.IOException;

public class ThrowTest {
    void catchException(){
        try{
            throwIndexOutOfBoundsException();

        }catch (RuntimeException e){
            System.out.println("Catch RunTimeException");
        }
    }

    void throwIOException() throws IOException{
        throw new IOException();
    }

    void throwIndexOutOfBoundsException(){
        throw new IndexOutOfBoundsException();
    }


}
