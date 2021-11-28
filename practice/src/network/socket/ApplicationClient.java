package network.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ApplicationClient {
    public static void main(String[] args) {
        OutputStreamWriter osw;
        InputStreamReader isr;

        try(Socket socket = new Socket("localhost", 7009)) {
            socket.setSoTimeout(20000);

            osw = new OutputStreamWriter(socket.getOutputStream());

            osw.write("내일 학교에 몇 시에 올래" + "\r\n");
            System.out.println("서버 친구에게 메세지를 보내다");

            osw.flush();
            socket.shutdownOutput();

            isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
            StringBuilder reply = new StringBuilder();
            for(int c = isr.read(); c!= -1; c = isr.read()) {
                reply.append((char) c);
            }
            System.out.println("서버 친구로부터 받은 메세지 : " + reply);

            osw.close();
            isr.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
