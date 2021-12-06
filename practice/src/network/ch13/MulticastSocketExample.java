package network.ch13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSocketExample {

    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            socket = new MulticastSocket(2300);
            InetAddress group = InetAddress.getByName("224.2.2.2");
            socket.joinGroup(group);

            byte[] buffer = new byte[8192];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            socket.receive(dp);

            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
