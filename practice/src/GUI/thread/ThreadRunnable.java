package GUI.thread;

public class ThreadRunnable implements Runnable {

    int i = 0;
    @Override
    public void run() {
        while(true) {
            System.out.println(1000 + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
