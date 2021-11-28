package network.ch8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeConnection {

    public static void main(String[] args)  {

        try(Socket socket = new Socket("time.nist.gov", 13)) {
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            StringBuilder time = new StringBuilder();
            for(int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
