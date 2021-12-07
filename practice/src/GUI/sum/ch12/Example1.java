package GUI.sum.ch12;

import javax.swing.*;
import java.awt.*;

public class Example1 extends JFrame {

    Example1() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.blue);
                g.drawRect(10,10,50,50);
                g.drawRect(50,50,50,50);
                g.drawRect(90,90,50,50);
            }
        };

        add(panel);
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example1();
    }
}
