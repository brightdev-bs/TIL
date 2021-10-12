package network.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ch2_2 {

    public static void main(String[] args) throws IOException {
        OutputStream ops = new FileOutputStream("file02.dat");
        for(int i = 33; i < 125; i++) {
            ops.write(i);
        }
        ops.close();
    }
}
