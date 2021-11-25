package GUI.thread;

import java.io.IOException;

public class ThreadEx_5 {
    static class Data {
        double sum = 0;
    }

    static class Consumer implements Runnable {
        Data data;
        Consumer(Data d) {
            data = d;
        }
        @Override
        public void run() {
            synchronized (data) {
                if(data.sum == 0) {
                    try {
                        data.wait();
                    } catch(InterruptedException e) {
                        return;
                    }
                }
            }
            System.out.println(data.sum / 1000);
        }
    }

    static class Producer implements Runnable {
        Data data;
        Producer(Data d) {
            data = d;
        }

        @Override
        public void run() {
            synchronized (data) {
                for(int i = 0; i <1000; i++) {
                    data.sum += Math.random();
                }
                data.notify();
            }
        }
    }

    public static void main(String[] args) {
        Data data = new Data();
        new Thread(new Consumer(data)).start();
        new Thread(new Producer(data)).start();
    }
}
