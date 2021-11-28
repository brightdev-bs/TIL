package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Ch12_2 extends JFrame {

    Ch12_2() {
        setSize(300,300);

        add(new MyPanel());

        setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.red);
            Font f = new Font("Arial", Font.ITALIC, 30);
            g.setFont(f);
            g.setColor(Color.yellow);
            g.drawString("How much", 50,50);
        }
    }

    public static void main(String[] args) {
        new Ch12_2();
    }
}
