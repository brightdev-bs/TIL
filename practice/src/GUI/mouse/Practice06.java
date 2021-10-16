package GUI.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Practice06 extends JFrame {
    JLabel label;
    Font font;
    class MouseWheel implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            System.out.println("실행됨");
            int i = e.getWheelRotation();
            font = label.getFont();
            int size = font.getSize();
            if(i < 0) {
                label.setFont(new Font("Arial", Font.PLAIN, size - 5));
            } else {
                label.setFont(new Font("Arial", Font.PLAIN, size + 5));
            }
        }
    }

    Practice06() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        setContentPane(panel);

        label = new JLabel("Beautiful October");
        font = new Font("Arial", Font.PLAIN, 10);
        label.setFont(font);
        //label.addMouseListener(new MouseWheel());
        panel.add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Practice06();
    }
}
