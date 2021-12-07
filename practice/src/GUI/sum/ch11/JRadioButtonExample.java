package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;

public class JRadioButtonExample extends JFrame {

    JRadioButtonExample() {
        ButtonGroup group = new ButtonGroup(); // 이게 필수

        JRadioButton btn = new JRadioButton("사과");
        JRadioButton btn2 = new JRadioButton("배");
        JRadioButton btn3 = new JRadioButton("체리");

        group.add(btn);
        group.add(btn2);
        group.add(btn3);

        add(btn); add(btn2); add(btn3);
        setLayout(new FlowLayout());
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JRadioButtonExample();
    }
}
