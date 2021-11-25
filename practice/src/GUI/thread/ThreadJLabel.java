package GUI.thread;

import javax.swing.*;

public class ThreadJLabel extends JLabel implements Runnable {
    JLabel label = new JLabel();
    int num = 0, time;

    @Override
    public void run() {
        while(true) {
            label.setText(String.valueOf(num++));
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    ThreadJLabel(JLabel label, int time) {
        this.time = time;
        this.label = label;
    }
}
