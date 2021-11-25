package GUI.thread;

public class ThreadTest {

    public static void main(String[] args) {
//        ThreadTimer time = new ThreadTimer();
//        time.start();

        Thread time = new Thread(new ThreadRunnable());
        time.start();
    }
}
