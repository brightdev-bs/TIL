package GUI.sum.ch12;

import javax.swing.*;
import java.awt.*;

public class Example2 extends JFrame {

    Example2() {
        MyPanel panel = new MyPanel();
        add(panel);

        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new Example2();
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);
            g.drawString("자바는 재밌다.", 30,30);
            g.setColor(Color.green);
            g.drawString("얼마나? 하늘만큼 땅만큼" , 60,60);
        }
    }
}
