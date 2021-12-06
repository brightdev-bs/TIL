package network.ch12;

import java.io.IOException;
import java.net.*;

public class UDPClientExample {

    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(13)) {
            socket.setSoTimeout(30000);
            InetAddress host = InetAddress.getByName("time.nist.gov");
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, 13);
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.send(request);
            socket.receive(response);

            String result = new String(response.getData(), 0, response.getLength());
            System.out.println(result);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
