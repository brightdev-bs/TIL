package network.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPDiscardClient {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(0)) {
            InetAddress server = InetAddress.getByName("localhost");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String theLine = input.readLine();
                if(theLine.equals(".")) break;
                byte[] data = theLine.getBytes();
                DatagramPacket theOutput = new DatagramPacket(data, data.length, server, 9);
                socket.send(theOutput);
            }
        }catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
