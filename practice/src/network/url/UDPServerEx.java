package network.url;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class UDPServerEx {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            DatagramPacket request = new DatagramPacket(new byte[1024], 0, 1024);
            socket.receive(request); // UDP패킷이 도착할 때까지 무한 대기.

            String daytime = new Date().toString() + "\r\n";
            byte[] data = daytime.getBytes("US-ASCII");
            InetAddress host = request.getAddress();
            int port = request.getPort();
            DatagramPacket response = new DatagramPacket(data, data.length, host, port);

            socket.send(response);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
