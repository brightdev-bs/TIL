package GUI.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutEx4 extends JFrame {

    BoxLayoutEx4() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        Box box = Box.createHorizontalBox();
        box.add(new JButton("1"));
        box.add(Box.createHorizontalStrut(10));
        box.add(new JButton("2"));
        box.add(Box.createHorizontalStrut(10));
        box.add(new JButton("3"));

        Box box2 = Box.createVerticalBox();
        box2.add(new JButton("A"));
        box2.add(Box.createVerticalStrut(10));
        box2.add(new JButton("B"));
        box2.add(Box.createVerticalStrut(10));
        box2.add(new JButton("C"));

        add(box);
        add(box2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutEx4();
    }
}
