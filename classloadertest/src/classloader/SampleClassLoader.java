package classloader;

public class SampleClassLoader {
    void classNotFoundExceptionTest() throws ClassNotFoundException {
        System.out.println(this.getClass().getClassLoader().loadClass("HelloWorld"));
        Class.forName("HelloWorld");
    }
}
