package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Example2 extends JFrame {
    Example2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("자바는 재밌다.", 30, 30);
                g.drawString("하늘만큼 땅만큼", 60,60);
            }
        };

        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example2();
    }
}
