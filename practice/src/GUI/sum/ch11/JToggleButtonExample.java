package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;

public class JToggleButtonExample extends JFrame {

    JToggleButtonExample() {
        JToggleButton[] button = { new JToggleButton("hi"), new JToggleButton("HELLO"), new JToggleButton("END")};
        ButtonGroup group = new ButtonGroup();
        Box box = Box.createVerticalBox();
        for(JToggleButton btn : button) {
            box.add(btn);
            group.add(btn);
            box.add(Box.createVerticalStrut(5));
        }

        setLayout(new FlowLayout());
        add(box);
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JToggleButtonExample();
    }
}
