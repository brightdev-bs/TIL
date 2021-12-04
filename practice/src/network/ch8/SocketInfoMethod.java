package network.ch8;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketInfoMethod {
    public static void main(String[] args) {
        for(String host : args) {
            try {
                Socket socket = new Socket(host, 80);
                System.out.println("Conncted to " + socket.getInetAddress() + " on port " + socket.getPort() + "from port " + socket.getLocalPort()
                 + "of" + socket.getLocalAddress());
            } catch(UnknownHostException ex) {
                System.out.println("i cant find " + host);
            } catch(SocketException ex) {
                System.out.println("Could not connect to " + host);
            } catch(IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
