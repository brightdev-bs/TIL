package network.ch8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketExample {

    public static void main(String[] args) {
        try(Socket socket = new Socket("time.nist.gov", 13)) {
            socket.setSoTimeout(3000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader isr = new InputStreamReader(in, "ASCII");
            for(int c = isr.read(); c  != -1;  c = isr.read()) {
                time.append((char)c);
            }
            System.out.println(time);
        } catch(IOException e) {}

    }
}
