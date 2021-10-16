package GUI.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Practice01 extends JFrame {
    class MouthListener implements MouseListener {
        public MouthListener() {
            super();
        }

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
            btn.setBackground(Color.pink);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton btn = (JButton) e.getSource();
            btn.setBackground(Color.YELLOW);
        }
    }

    Practice01() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JButton button = new JButton("Mouse Event 테스트 버튼");
        button.setBackground(Color.YELLOW);

        MouthListener mouthListener = new MouthListener();
        button.addMouseListener(mouthListener);
        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Practice01();
    }
}
