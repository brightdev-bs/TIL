package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Ch12_3 extends JFrame {

    Ch12_3() {
        setSize(300,300);

        add(new MyPanel());

        setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.red);
            g.drawLine(100,100,100,100);
            //g.drawLine(20,20,100,100);
            //g.drawLine(100,20,20,100);
        }
    }



    public static void main(String[] args) {
        new Ch12_3();
    }
}
