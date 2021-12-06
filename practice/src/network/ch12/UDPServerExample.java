package network.ch12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class UDPServerExample {

    public static void main(String[] args) {
        try(DatagramSocket server = new DatagramSocket(0)) {
            while(true) {
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                server.receive(request);

                String daytime = new Date().toString();
                byte[] data = daytime.getBytes(StandardCharsets.UTF_8);
                DatagramPacket response = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
                server.send(response);
            }
        }catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
