package GUI.thread;

public class ThreadEx1 {

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while(true) {
            System.out.println(1000 + i++);
            Thread.sleep(1000);
        }
    }
}
