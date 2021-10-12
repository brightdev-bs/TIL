package network.ch2;

import java.io.*;

public class CheckByteImage {

    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream("springboot.png");

        byte[] tmp = new byte[1024];
        int count = fis.read(tmp);

        for(int i = 0; i < count; i++) {
            int alpha = tmp[i] & 0xff;
            System.out.print(alpha + "");
            if(i % 8 == 7) System.out.print("\n");
            else System.out.print('\t');
        }
    }
}
