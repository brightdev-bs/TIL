package network.writerAndReader;

import java.io.*;

public class Important {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hangeul.txt"));
        PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter("outputFile.txt")));
        String s;
        while((s = br.readLine()) != null) {
            bw.println(s);
        }
        bw.close();
        br.close();

    }
}
