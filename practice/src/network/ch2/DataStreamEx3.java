package network.ch2;

import java.io.*;

public class DataStreamEx3 {

    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("real.dat"));
        for(int i = 0; i < 5; i++) {
            dos.writeDouble(Math.random());
        }
        dos.flush();
        dos.close();

        FileInputStream fis = new FileInputStream("real.dat");
        int k, total = 0;
        while((k = fis.read()) != -1) {
            total++;
            System.out.print(k + " ");
        }
        System.out.println("\n" + total);
        fis.close();

        int total2 = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("real.dat"));

            while(true) {
                double theRead = dis.readDouble();
                total2++;
                System.out.print(theRead + " ");
            }
        }catch(EOFException e) {
            System.out.print("\n" + total2);
        }
    }
}
