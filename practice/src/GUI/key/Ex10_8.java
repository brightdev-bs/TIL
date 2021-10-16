package GUI.key;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex10_8 extends JFrame {
    JLabel label;

    class KeyControl implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                label.setLocation(label.getX() + 10, label.getY());
            else if(e.getKeyCode() == KeyEvent.VK_LEFT)
                label.setLocation(label.getX() - 10, label.getY());
            else if(e.getKeyCode() == KeyEvent.VK_DOWN)
                label.setLocation(label.getX(), label.getY() + 10);
            else if(e.getKeyCode() == KeyEvent.VK_UP)
                label.setLocation(label.getX(), label.getY() - 10);

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    Ex10_8() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        label = new JLabel("Hello");
        label.setFocusable(true);
        label.requestFocus();
        label.addKeyListener(new KeyControl());
        label.setLocation(50,50);
        label.setSize(100,20);

        panel.add(label);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex10_8();
    }
}
