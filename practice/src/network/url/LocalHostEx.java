package network.url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHostEx {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
        System.out.println(InetAddress.getByName("localhost"));

    }
}
