package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class CheckBoxExample2 extends JFrame {

    CheckBoxExample2() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배", true);
        ImageIcon icon = new ImageIcon(getClass().getResource("flower.jpeg"));
        JCheckBox cherry = new JCheckBox("체리", icon);

        setLayout(new FlowLayout());

        add(apple);
        add(pear);
        add(cherry);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxExample2();
    }
}
