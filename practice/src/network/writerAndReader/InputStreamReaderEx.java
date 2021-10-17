package network.writerAndReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("hangeul.txt"), "UTF-8");
        int k;
        while((k = isr.read()) != -1) {
            System.out.print((char)k);
        }

        isr.close();
    }
}
