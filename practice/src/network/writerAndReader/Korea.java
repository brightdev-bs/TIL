package network.writerAndReader;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Korea {

    public static void main(String[] args) throws IOException {
        Writer w = new OutputStreamWriter(System.out);

        w.write("KOREA 한국");
        w.flush();

    }
}
