package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class DrawLineExample extends JFrame {

    DrawLineExample() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(20, 20, 100, 100);
                g.drawLine(20,100, 100,20);
                g.drawLine(120, 120, 120, 120);
            }
        };

        add(panel);
        setVisible(true);
    }


    public static void main(String[] args) {
        new DrawLineExample();
    }
}
