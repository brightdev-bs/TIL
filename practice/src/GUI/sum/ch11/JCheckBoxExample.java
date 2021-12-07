package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;

public class JCheckBoxExample extends JFrame {

    JCheckBoxExample() {
        JCheckBox checkBox = new JCheckBox("사과");
        JCheckBox checkBox2 = new JCheckBox("배", true);

        add(checkBox); add(checkBox2);

        setLayout(new FlowLayout());
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JCheckBoxExample();
    }
}
