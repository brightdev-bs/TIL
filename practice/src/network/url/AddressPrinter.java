package network.url;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class AddressPrinter {

    public static void main(String[] args) {
        try {
            InetAddress[] addr = InetAddress.getAllByName("www.naver.com");
            InetAddress me = InetAddress.getLocalHost();
            System.out.println(me);
            for(InetAddress a : addr) {
                System.out.println(a);
            }
        } catch(UnknownHostException e) {
            System.err.println(e);
        }
    }
}
