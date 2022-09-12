package classloader;

public class Main {
    public static void main(String[] args) {
//        callSampleClassLoader();
        callPrintClassLoaders();
    }

    public static void callPrintClassLoaders(){
        PrintClassLoader printClassLoader = new PrintClassLoader();
        try {
            printClassLoader.printClassLoaders();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void callSampleClassLoader(){
        SampleClassLoader sampleClassLoader = new SampleClassLoader();
        try {
            sampleClassLoader.classNotFoundExceptionTest();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
