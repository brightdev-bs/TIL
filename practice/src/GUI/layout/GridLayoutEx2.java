package GUI.layout;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx2 extends JFrame {

    GridLayoutEx2() {
        setSize(300,300);
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(layout);

        JButton button = new JButton("Left");
        panel.add(button, c);
        JButton button2 = new JButton("Center");
        panel.add(button2, c);
        JButton button3 = new JButton("Right");
        panel.add(button3, c);

        c.fill = GridBagConstraints.BOTH;
        JButton button4 = new JButton("Left2");
        c.weighty = 1.0;
        c.weightx = 0.1;
        c.gridy = 1;
        panel.add(button4, c);
        JButton button5 = new JButton("Center2");
        c.weightx = 0.3;
        c.gridy = 1;
        panel.add(button5, c);
        JButton button6 = new JButton("Right2");
        c.weightx = 0.6;
        c.gridy = 1;
        panel.add(button6, c);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutEx2();
    }
}
