package network.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ch2_3 {
    public static void main(String[] args) throws IOException {
        OutputStream ops = new FileOutputStream("file03.dat");
        byte[] arr = new byte[26];
        for(int i = 0; i < 26; i++) {
            arr[i] = (byte) (i + 65);
        }
        ops.write(arr);
        ops.close();
    }
}
