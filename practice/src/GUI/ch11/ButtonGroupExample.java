package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class ButtonGroupExample extends JFrame {

    ButtonGroupExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JToggleButton[] buttons = new JToggleButton[] {
            new JToggleButton(new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower.jpeg")),
            new JToggleButton(new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower2.jpeg")),
            new JToggleButton(new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower3.jpeg"))
        };

        ButtonGroup group = new ButtonGroup();
        Box box = Box.createHorizontalBox();
        for(JToggleButton btn : buttons) {
            group.add(btn);
            box.add(Box.createVerticalStrut(5));
            box.add(btn);
        }

        setLayout(new FlowLayout());
        add(box);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new ButtonGroupExample();
    }
}
