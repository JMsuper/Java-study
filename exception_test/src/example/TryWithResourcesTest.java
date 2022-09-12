package example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesTest {
    String test(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        try {
            return br.readLine();
        } finally {
            br.close();
            fr.close();
        }
    }
}
