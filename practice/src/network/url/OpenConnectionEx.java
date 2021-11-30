package network.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class OpenConnectionEx {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.naver.com");
            try {
                URLConnection uc = u.openConnection();
                InputStream in = uc.getInputStream();
                int c;
                while((c = in.read()) != -1) {
                    System.out.write(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
