package GUI.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CardLayoutExAgain extends JFrame {
    JPanel panel;

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

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    CardLayoutExAgain() {
        setSize(300,300);

        MouseControl mc = new MouseControl();

        panel = new JPanel(new CardLayout());
        JButton button = new JButton("0번째 패널");
        button.addMouseListener(mc);
        JButton button2 = new JButton("1번째 패널");
        button2.addMouseListener(mc);
        JButton button3 = new JButton("2번째 패널");
        button3.addMouseListener(mc);
        JButton button4 = new JButton("3번째 패널");
        button4.addMouseListener(mc);

        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        add(panel, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CardLayoutExAgain();
    }
}
