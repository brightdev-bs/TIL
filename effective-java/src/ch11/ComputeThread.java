package ch11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComputeThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
