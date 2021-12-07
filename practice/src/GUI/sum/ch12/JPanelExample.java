package GUI.sum.ch12;

import javax.swing.*;
import java.awt.*;

public class JPanelExample extends JFrame {

    JPanelExample() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.setColor(Color.yellow);
                g.drawString("May the Force be with you", 50,50);
            }
        };
        panel.setBackground(Color.red);

        setSize(300,300);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JPanelExample();
    }
}
