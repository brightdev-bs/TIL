package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class JToggleButtonExample extends JFrame {

    JToggleButtonExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("flower.jpeg"));
        setSize(600,600);
        setLayout(new FlowLayout());
        JToggleButton toggleBtn = new JToggleButton(icon);
        add(toggleBtn);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JToggleButtonExample();
    }

}
