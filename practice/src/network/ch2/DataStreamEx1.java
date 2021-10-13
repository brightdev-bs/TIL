package network.ch2;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataStreamEx1 {
    static int[] prime = {2,3,5,7,11,13,17,19,23,29};

    public static void main(String[] args) throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("prime.bin", true));
        for(int i = 0; i < 10; i ++) {
            dos.writeInt(prime[i]);
        }

        dos.close();
    }
}
