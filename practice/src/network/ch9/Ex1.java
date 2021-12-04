package network.ch9;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex1 {

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(7009)) {
            while(true) {
                Socket con = server.accept();
                InputStreamReader br = new InputStreamReader(con.getInputStream(), "MS949");
                StringBuilder sb = new StringBuilder();
                for (int c = br.read(); c != -1; c = br.read()) {
                    sb.append((char)c);
                }
                System.out.println("클라이언트에서 보냄 : " + sb);
                con.shutdownInput();
                OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
                osw.write("나 10시에 갈 예정이야" + "\r\n");
                osw.flush();
                con.shutdownOutput();
                osw.close();
                con.close();
            }
        }catch(IOException e) {
            System.err.println(e);
        }
    }
}
