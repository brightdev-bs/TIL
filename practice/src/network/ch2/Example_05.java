package network.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Example_05 {

    public static void main(String[] args) throws IOException {
        OutputStream ops = new FileOutputStream("file_191.dat");
        ops.write(-191);
        ops.close();
    }
}
