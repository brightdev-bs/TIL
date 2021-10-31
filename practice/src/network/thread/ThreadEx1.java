package network.thread;

import java.util.concurrent.ExecutorService;

public class ThreadEx1 extends Thread {
    String sen;
    int delay;
    ThreadEx1(String s, int time) {
        sen = s;
        delay = time;
    }

    public void run() {
        try {
            for(;;) {
                System.out.println(sen + " ");
                sleep(delay);
            }
        }catch(InterruptedException e) {
            return;
        }
    }

    public static void main(String[] args) {
        new ThreadEx1("QUICK", 33).start();
        new ThreadEx1("slow", 100).start();

        //ExecutorService
    }
}
