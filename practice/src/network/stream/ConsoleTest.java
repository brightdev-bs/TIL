package network.stream;

import java.io.IOException;

public class ConsoleTest {

    public static void main(String[] args) throws IOException {
        int count = 0;
        int b =System.in.read();
        while(b!= -1) {
            count++;
            System.out.println(b + " " + (char) b);
            b = System.in.read();
        }
        System.out.println("count : " + count);
    }
}
