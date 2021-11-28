package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Ch12_1 extends JFrame {

    Ch12_1() {
        setSize(300,300);
        JPanel panel = new MyPanel();
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(10,10,50,50);
            g.drawRect(30,30,50,50);
            g.drawRect(50,50,50,50);
        }
    }

    public static void main(String[] args) {
        Ch12_1 m = new Ch12_1();
    }
}
