package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class JLabelExample extends JFrame {

    JLabelExample() {
        setLayout(new FlowLayout());

        add(new JLabel("Load"));
        add(new JLabel("Save"));
        add(new JLabel("Subscribe"));
        add(new JLabel("Unsub"));

        setVisible(true);
    }

    public static void main(String[] args) {
        new JLabelExample();
    }
}
