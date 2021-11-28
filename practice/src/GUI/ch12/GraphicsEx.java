package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class GraphicsEx extends JFrame {

    GraphicsEx() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new MyPanel();
        add(p, BorderLayout.CENTER);

        JButton btn = new JButton("hi");
        btn.setForeground(Color.red);
        add(btn, BorderLayout.NORTH);

        setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("hi",2,2);
        }
    }

    public static void main(String[] args) {
        GraphicsEx e = new GraphicsEx();
    }
}
