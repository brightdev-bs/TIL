package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Example1 extends JFrame {

    Example1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new MyPanel();
        add(panel, BorderLayout.CENTER);
        setSize(400,400);
        setVisible(true);

    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.blue);
            g.drawRect(10, 10, 50, 50);
            g.drawRect(50,50,50,50);
            g.drawRect(90,90,50,50);
        }
    }

    public static void main(String[] args) {
        new Example1();
    }
}
