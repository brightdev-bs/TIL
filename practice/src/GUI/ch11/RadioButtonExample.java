package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class RadioButtonExample extends JFrame {

    RadioButtonExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        ButtonGroup group = new ButtonGroup();
        JRadioButton btn = new JRadioButton("사과");
        JRadioButton btn2 = new JRadioButton("배");
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        JRadioButton btn3 = new JRadioButton("체리", icon, true);
        btn3.setBorderPainted(true);
        btn3.setSelectedIcon(new ImageIcon(getClass().getResource("flower.jpeg")));

        group.add(btn); group.add(btn2); group.add(btn3);
        add(btn); add(btn2); add(btn3);

        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new RadioButtonExample();
    }
}
