package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class JLabelImageMaker extends JFrame {

    ImageIcon icon = new ImageIcon(getClass().getResource("flower.jpeg"));

    JLabelImageMaker() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel 이용 방법
//        JLabel label = new JLabel(new ImageIcon(getClass().getResource("flower.jpeg")));
//        label.setBorder(new TitledBorder("JLabel Image"));
//        add(label);
//        setVisible(true);

        // paintComponent() 오버라이딩 방법
        MyJLabel label = new MyJLabel();
        add(label);
        setVisible(true);
    }

    class MyJLabel extends JLabel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //g.drawImage(icon.getImage(), 20,20, 100,100,this);
            //g.drawImage(icon.getImage(),0,0, getWidth(), getHeight(), this);
            //icon.paintIcon(this, g, 0, 50);

        }
    }

    public static void main(String[] args) {
        new JLabelImageMaker();
    }
}
