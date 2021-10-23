package GUI.hw;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BigText extends JFrame {

    BigText() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1,1));

        JTextField textField = new JTextField(1);
        textField.setBorder(new TitledBorder("TextField"));
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                textField.setText(String.valueOf(e.getKeyChar()));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        add(textField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BigText();
    }
}
