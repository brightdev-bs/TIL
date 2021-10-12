package network.ch2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MakeMyFile {

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("myFile.txt");
        byte n = (byte) is.read();
        while(n != -1) {
            System.out.print((char) n);
            n = (byte) is.read();
        }
        is.close();
    }
}
