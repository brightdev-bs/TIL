package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Cliping extends JFrame {

    ImageIcon icon = new ImageIcon(getClass().getResource("flower.jpeg"));


    Cliping() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setClip(100, 20, 150, 150);
                g.drawImage(icon.getImage(), 0,0,getWidth(), getHeight(),this);
            }
        };
        add(label);

        setVisible(true);

    }


    public static void main(String[] args) {
        new Cliping();
    }
}
