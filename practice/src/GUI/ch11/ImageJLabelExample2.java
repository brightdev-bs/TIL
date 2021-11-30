package GUI.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageJLabelExample2 extends JFrame {

    ImageJLabelExample2() {
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Chirstmas");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();
                Font f = label.getFont();
                int size = f.getSize() + 5;
                label.setFont(new Font(f.getName(), f.getStyle(), size));
            }
        });

        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageJLabelExample2();
    }
}
