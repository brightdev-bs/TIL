package network.writerAndReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Hanguel {

    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("hangeul.txt"), "MS949");
        osw.write("자바의 outputStreamWriter 스트림 사용 연습");
        osw.close();
    }
}
