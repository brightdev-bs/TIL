package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class ImageResizer extends JFrame {
    ImageIcon icon = new ImageIcon(getClass().getResource("flower.jpeg"));

    ImageResizer(){
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyImageLabel label = new MyImageLabel();
        add(label);
        setVisible(true);
    }

    class MyImageLabel extends JLabel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(icon.getImage(), 20, 20, 250, 100, 100, 50, 200, 200, this);
            //g.drawImage(icon.getImage(), 20,20,250,100,50, 0,150,150,this);
        }
    }

    public static void main(String[] args) {
        new ImageResizer();
    }
}
