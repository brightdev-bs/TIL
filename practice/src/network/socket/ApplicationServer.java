package network.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ApplicationServer {
    public static void main(String[] args) {
        Socket socket = null;
        InputStreamReader isr;
        OutputStreamWriter osw;
        StringBuilder message;

        try (ServerSocket server = new ServerSocket(7009)){
            System.out.println("연결 기다리는 중 --");
            socket = server.accept();
            System.out.println("클라이언트와 연결 성공");

            isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
            message = new StringBuilder();
            for(int c = isr.read(); c != -1; c = isr.read()) {
                message.append((char)c);
            }
            socket.shutdownInput();
            System.out.println("클라이언트 친구로부터 받은 메세지 : " + message);

            osw = new OutputStreamWriter(socket.getOutputStream());
            osw.write("나 9시에 갈 예정이야" + "\r\n");
            System.out.println("전송");

            osw.flush();
            socket.shutdownOutput();
            osw.close();
            isr.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
