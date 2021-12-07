package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JLabelExample extends JFrame {
    Font font = new Font("Arial", Font.PLAIN, 5);

    JLabelExample() {
        JLabel label = new JLabel("hi", SwingConstants.CENTER);
        label.setFont(font);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int size = font.getSize();
                font = new Font(font.getName(), font.getStyle(), size+5);
                label.setFont(font);
            }
        });
        add(label);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JLabelExample();
    }
}
