package GUI.thread;

import javax.swing.*;
import java.awt.*;

public class ThreadJText extends JFrame {
    int[] times = {1, 2, 3};
    JLabel[] labels = new JLabel[3];

    ThreadJText() {
        setSize(300,300);
        Container c = getContentPane();
        setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        for(int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            add(labels[i]);
        }

        for(int i = 0; i < labels.length; i++) {
            new Thread(new ThreadJLabel(labels[i], times[i])).start();
        }

        setVisible(true);

    }

    public static void main(String[] args) {
        new ThreadJText();
    }
}
