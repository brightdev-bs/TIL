package network.writerAndReader;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintStreamEx {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("myFile.txt");
        pw.write("Korea 한국");
        pw.flush();
        pw.close();
    }
}
