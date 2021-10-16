package GUI.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Practice04 extends JFrame {
    JPanel panel;
    JLabel l;

    class MouseControls implements MouseListener, MouseMotionListener {
        public MouseControls() {
            super();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            l.setText("mouseClicked (" + x + ", " + y + " )");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            l.setText("MousePressed (" + x + ", " + y + " )");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            l.setText("MouseReleased (" + x + ", " + y + " )");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(Color.cyan);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(Color.YELLOW);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            l.setText("mouseDragged (" + x + ", " + y + " )");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            l.setText("mouseMoved (" + x + ", " + y + " )");
        }
    }

    Practice04() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        MouseControls mouseControls = new MouseControls();
        panel = new JPanel();
        setContentPane(panel);
        panel.setBackground(Color.white);
        panel.addMouseListener(mouseControls);
        panel.addMouseMotionListener(mouseControls);

        l = new JLabel("No Mouse Event");
        panel.add(l);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Practice04();
    }
}
