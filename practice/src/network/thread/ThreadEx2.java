package network.thread;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ThreadEx2 {

    public static void main(String[] args) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha.digest();
            System.out.println(DatatypeConverter.printHexBinary(digest));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
