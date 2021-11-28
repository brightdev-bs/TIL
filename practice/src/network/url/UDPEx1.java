package network.url;

import java.io.IOException;
import java.net.*;

public class UDPEx1 {

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(0);
            ds.setSoTimeout(10000);

            InetAddress host = InetAddress.getByName("time.nist.gov");
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, 13);

            byte[] data = new byte[1024];
            DatagramPacket response = new DatagramPacket(data, data.length);

            ds.send(request);
            ds.receive(response);

            String daytime = new String(response.getData(), 0, response.getLength(), "US-ASCII");
            System.out.println(daytime);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

