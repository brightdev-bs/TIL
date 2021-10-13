package network.ch2;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class DataStreamEx2 {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("textFile.txt");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("binaryFile.bin"));

        int k;
        while((k = is.read()) != -1) {
            dos.writeInt(k);
        }

        dos.close();
        is.close();
    }
}
