package GUI.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ch10_4 extends JFrame {

    JPanel panel = new JPanel();
    JLabel label = new JLabel("키 입력해");
    Ch10_4() {
        setSize(300,300);

        setContentPane(panel);
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String s = KeyEvent.getKeyText(e.getKeyCode());
                label.setText(s + " 키가 입력되었습니다");
                if(e.getKeyChar() == '%') panel.setBackground(Color.YELLOW);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        panel.add(label);
        panel.setFocusable(true);
        panel.requestFocus();
        setVisible(true);

    }

    public static void main(String[] args) {
        new Ch10_4();
    }
}
