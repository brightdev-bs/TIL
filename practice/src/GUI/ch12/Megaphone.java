package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Megaphone extends JFrame {

    Megaphone() {
        setBounds(0,0,450,450);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.black);
                setBackground(new Color(192,192,192));
                for(int radius = 0; radius < 400; radius += 10) {
                    int r = 400 - radius;
                    g.drawOval(10,10,r,r);
                }
            }
        };

        add(panel);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Megaphone();
    }
}
