package network.ch9;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Ex1_Client {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 7009)) {
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            osw.write("내일 학교 몇 시에 올래?");
            osw.flush();
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            StringBuilder br = new StringBuilder();
            for(int r = isr.read(); r != -1; r = isr.read()) {
                br.append((char)r);
            }
            System.out.println(br);

            osw.close();
            isr.close();
        }catch(IOException e) {
            System.err.println(e);
        }
    }
}
