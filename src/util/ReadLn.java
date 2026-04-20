package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLn {

    private BufferedReader reader;

    public ReadLn(String filename) throws IOException {
        reader = new BufferedReader(new FileReader(filename));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        reader.close();
    }
    
}
