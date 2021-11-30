package network.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class OpenStreamEx {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.naver.com/");
            try(InputStream in = u.openStream()) {
                int c;
                while((c = in.read()) != -1)
                    System.out.write(c);
            }
            System.out.println(u.toString());
            System.out.println(u.hashCode());
            System.out.println(u.toExternalForm());
            System.out.println(u.toURI());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
