package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Ex extends JFrame {

    Ex() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(0,0,400,200);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.YELLOW);
                Font font = new Font("Flat Brush", Font.BOLD, 24);
                g.setFont(font);
                setBackground(Color.red);
                g.drawString("May the Force be  with you", 50, 50);
            }
        };

        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Ex();
    }
}
