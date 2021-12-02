package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Example3 extends JFrame {

    Example3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        MyPanel panel = new MyPanel();
        c.add(panel, BorderLayout.CENTER);
        setSize(540,500);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.setColor(Color.blue);
            g.drawString("I love Java", 30,30);
            g.setColor(new Color(255,0,0));
            g.setFont(new Font("Arial", Font.ITALIC, 30));
            g.drawString("How much", 30, 60);
            g.setColor(new Color(0x00ff00ff));
            for(int i = 1; i <= 5; i++) {
                g.setFont(new Font("Jokerman", Font.ITALIC, i * 10));
                g.drawString("This much", 30, 60 + i * 60);
            }
        }
    }

    public static void main(String[] args) {
        new Example3();
    }
}
