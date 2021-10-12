package network.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ch2_1 {

    public static void main(String[] args) throws IOException {
        OutputStream ops = new FileOutputStream("Ch2_1.txt");
        for(int i = 65; i < 65 + 26; i++) {
            ops.write(i);
        }
        ops.close();
    }
}
