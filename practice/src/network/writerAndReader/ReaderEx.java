package network.writerAndReader;

import java.io.*;

public class ReaderEx {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("randomDouble.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDouble.txt"));
        String s;
        while((s = br.readLine()) != null) {
            bw.write(s);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
