package network.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ch2_4 {

    public static void main(String[] args) throws IOException {
        OutputStream ops = new FileOutputStream("school.dat");
        String s = "자랑스러운 우리학교";
        byte[] arr = s.getBytes();
        ops.write(arr);
        ops.close();

    }
}
