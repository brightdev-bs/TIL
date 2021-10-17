package network.writerAndReader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("hangeul.txt");
        int k;
        while((k=fr.read())!= -1) {
            System.out.print((char)k);
        }
    }
}
