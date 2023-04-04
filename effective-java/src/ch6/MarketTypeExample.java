package ch6;

import java.io.*;

public class MarketTypeExample {

    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new DataOutputStream(System.out));
        Juice juice = new Juice("망고주스", 1000);
        oos.writeObject(juice);
        oos.write(Byte.decode(juice.toString()));
    }
}
