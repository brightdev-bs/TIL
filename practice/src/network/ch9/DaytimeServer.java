package network.ch9;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer {

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(13)) {
            while(true) {
                Socket connection = server.accept();
                Writer writer = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                writer.write(now.toString() + "\r\n");
                writer.flush();
                System.out.println("connection : " + connection.getInetAddress());
                connection.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
