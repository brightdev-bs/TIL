package network.filter;

import java.io.*;

public class DataOutputStreamEx {

    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("randomDouble.txt"));
        for(int i = 0; i < 5; i++) {
            dos.writeDouble(Math.random());
        }
        dos.flush();
        dos.close();

        int total = 0;
        FileInputStream fis = new FileInputStream("randomDouble.txt");
        int k;
        while((k = fis.read()) != -1) {
            total++;
            System.out.print(k + " ");
        }
        System.out.println(total);
        fis.close();

        int total2 = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("randomDouble.txt"));
            double j;
            while((j = dis.readDouble()) != -1) {
                total2++;
                System.out.print(j + " ");
            }
            System.out.println("total2 : " + total2);
        }catch(EOFException e) {
            System.out.println("출력됨");
        }


    }
}
