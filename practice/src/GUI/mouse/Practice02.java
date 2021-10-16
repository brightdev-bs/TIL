package GUI.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;

public class Practice02 extends JFrame {

    class MouseControl implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton btn = (JButton) e.getSource();
            String s = btn.getText();
            btn.setText(s.toLowerCase());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton btn = (JButton) e.getSource();
            String s = btn.getText();
            btn.setText(s.toUpperCase());
        }
    }

    Practice02() {
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        MouseControl mouseControl = new MouseControl();

        for(int i = 0; i < 26; i++) {
            char c = (char)(i + 'A');
            JButton button = new JButton(String.valueOf(c));
            button.addMouseListener(mouseControl);
            add(button);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Practice02();
    }
}
