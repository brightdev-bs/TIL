package GUI.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChFont extends JFrame {
    JLabel label;
    Font font;
    int size = 10;
    ChFont() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Love Java");

        font = new Font("Arial", Font.PLAIN, size);
        label.setFont(font);

        label.setFocusable(true);
        label.requestFocus();

        label.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == '+') {
                    font = new Font("Arial", Font.PLAIN, size = size + 5);
                    label.setFont(font);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        add(label, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ChFont();
    }
}
