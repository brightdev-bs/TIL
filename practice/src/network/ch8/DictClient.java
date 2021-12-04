package network.ch8;

import java.io.*;
import java.net.Socket;

public class DictClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("dict.org", 2628)) {
            socket.setSoTimeout(10000);
            OutputStream os = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(os, "UTF-8");
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            for(String word: args) {
                define(word, writer, br);
            }

            writer.write("quit\r\n");
            writer.flush();

        }catch(IOException e) {
            System.err.println(e);
        }
    }

    static void define(String word, Writer writer, BufferedReader reader) throws IOException, UnsupportedEncodingException {
        writer.write("DEFINE fd-eng-lat " + "\r\n");
        writer.flush();

        for(String line = reader.readLine(); line != null; line = reader.readLine()) {
            if(line.startsWith("250 ")) {
                return;
            } else if(line.startsWith("552 ")) {
                System.out.println("No Definiton found for " + word);
                return;
            }
            else if(line.matches("\\d\\d\\d .*")) continue;
            else if(line.trim().equals(".")) continue;
            else System.out.println(line);
        }
    }
}
