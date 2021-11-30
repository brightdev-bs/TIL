package GUI.ch11;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JButtonExample extends JFrame {
    ImageIcon img, upImg, clickImg;

    JButtonExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        img = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower.jpeg");
        upImg = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower2.jpeg");
        clickImg = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower3.jpeg");

        JButton btn = new JButton(img);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JButton btn = (JButton) e.getSource();
                btn.setIcon(upImg);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JButton btn = (JButton) e.getSource();
                btn.setIcon(clickImg);
            }
        });


        add(btn);

        pack();

        setVisible(true);

    }

    public static void main(String[] args) {
        new JButtonExample();
    }
}
