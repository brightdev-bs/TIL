package GUI.thread;

public class ThreadTimer extends Thread{

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
