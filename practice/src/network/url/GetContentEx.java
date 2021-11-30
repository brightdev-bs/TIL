package network.url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetContentEx {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.naver.com");
            Object o = u.getContent();
            System.out.println(o.getClass().getName());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
