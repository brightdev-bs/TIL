package GUI.sum.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelDrawImg extends JFrame {
    int startX, startY, endX, endY;

    JPanelDrawImg(){
        ImageIcon icon = new ImageIcon(getClass().getResource("tool.png"));
        Image img = icon.getImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.clipRect(startX, startY, endX - startX, endY - startY);
                g.drawImage(img, 0,0, getWidth(), getHeight(), null);
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                endX = e.getX();
                endY = e.getY();
                repaint();
            }
        });

        add(panel);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JPanelDrawImg();
    }
}
