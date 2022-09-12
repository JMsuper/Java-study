package example;

public class FinallyTest {
    void test(){
        try{
            return;
        }finally {
            System.out.println("method is returned");
        }
    }
}
