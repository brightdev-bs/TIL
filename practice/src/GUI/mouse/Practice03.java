package GUI.mouse;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice03 extends JFrame {

    class ThirdMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("mouseClicked : " + e.getX() + " " + e.getY());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("mousePressed : " + e.getX() + " " + e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("mouseReleased : " + e.getX() + " " + e.getY());
        }
    }

    Practice03() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ThirdMouseListener mouseListener = new ThirdMouseListener();
        JPanel panel = new JPanel();
        panel.addMouseListener(mouseListener);
        setContentPane(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Practice03();
    }
}
