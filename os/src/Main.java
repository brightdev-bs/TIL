public class Main {
    public static void main(String[] args) {
        ExampleThread t1 = new ExampleThread();

        Runnable r = new RunnableThread();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}
