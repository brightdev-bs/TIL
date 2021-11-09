package network.url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example4_1 {

    public static void main(String[] args) {
        try {
            InetAddress[] address = InetAddress.getAllByName("www.jnu.ac.kr");
            for(InetAddress s : address) {
                System.out.println(s);
            }
        } catch(UnknownHostException ex) {
            System.out.println("Couldn't find www.jnu.ac.kr");
        }
    }
}
