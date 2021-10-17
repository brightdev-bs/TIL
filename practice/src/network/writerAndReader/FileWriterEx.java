package network.writerAndReader;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("hanguel.txt");
        fw.write(123);
        fw.close();
    }
}
