package network.ch12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPDiscardServer {

    public static void main(String[] args) {
        byte[] buffer = new byte[65507];

        try(DatagramSocket server = new DatagramSocket(9)) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while(true) {
                try {
                    server.receive(packet);
                    String s = new String(packet.getData(), packet.getOffset(), packet.getLength());
                    System.out.println(packet.getAddress() + " at port " + packet.getPort() + " says " + s);
                    packet.setLength(buffer.length);
                }catch(IOException e) {}
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
