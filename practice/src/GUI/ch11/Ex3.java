package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class Ex3 extends JFrame {

    Ex3() {
        setSize(300,300);
        setLayout(new FlowLayout());

        Box aBox = Box.createHorizontalBox();
        getContentPane().add(aBox);

        JLabel first = new JLabel("componenet1");
        first.setOpaque(true);
        first.setBackground(Color.green);

        JLabel second = new JLabel("componenet2");
        second.setOpaque(true);
        second.setBackground(Color.green);

        JLabel third = new JLabel("componenet3");
        third.setOpaque(true);
        third.setBackground(Color.green);

        Dimension prefereedSize = first.getPreferredSize();
        prefereedSize.width = (int)(prefereedSize.width + 1.5);

        Dimension minSize = new Dimension();
        minSize.width = (int) (prefereedSize.width * 0.5);
        minSize.height = prefereedSize.height;

        Dimension maxSize = new Dimension();
        maxSize.width = (int) (prefereedSize.width * 2.0);
        maxSize.height = prefereedSize.height;

        first.setMinimumSize(prefereedSize);
        first.setMaximumSize(prefereedSize);

        second.setMinimumSize(minSize);
        second.setMaximumSize(maxSize);

        third.setMinimumSize(minSize);
        third.setMaximumSize(maxSize);

        aBox.add(Box.createHorizontalStrut(10));
        aBox.add(first);
        aBox.add(Box.createHorizontalStrut(10));
        aBox.add(second);
        aBox.add(Box.createHorizontalStrut(10));
        aBox.add(third);


        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex3();
    }
}
