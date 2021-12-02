package GUI.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClipingEx extends JFrame {


    ClipingEx() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyImage panel = new MyImage();
        add(panel);
        setSize(400,400);
        setVisible(true);
    }

    class MyImage extends JFrame {
        int x, y, x2, y2;
        ImageIcon icon = new ImageIcon(getClass().getResource("flower.jpeg"));

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
            System.out.println("프린트 시작됨");
            Rectangle r = g.getClipBounds();
            
        }

        MyImage() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    int x = getX();
                    int y = getY();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    int x2 = getX();
                    int y2 = getY();
                    repaint();
                }
            });

        }
    }

    public static void main(String[] args) {
        new ClipingEx();
    }
}
