package GUI.sum.ch12;

import javax.swing.*;
import java.awt.*;

public class FigureExample extends JFrame {
    int[] x = {40,80,120,80};
    int[] y = {80,120,80,40};

    FigureExample() {
        MyPanel panel = new MyPanel();
        add(panel);

        setVisible(true);
        setSize(300,300);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
//            g.drawOval(10,10, 100, 100);
//            g.setColor(Color.blue);
//            g.drawRoundRect(100,100, 200,140, 40, 60);
//            g.drawArc(10,10, 30,30, 90,270);
//            g.drawArc(30,30,30,30,90,-270);
//            g.drawPolygon(x, y, 4);
            g.setColor(Color.red);
            g.fillRect(10,10,50,50);
        }
    }

    public static void main(String[] args) {
        new FigureExample();
    }
}
