package GUI.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutEx extends JFrame {

    BoxLayoutEx() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        BoxLayout layout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(layout);

        JButton button = new JButton("hi");
        panel.add(button);
        panel.add(new JButton("second"));

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutEx();
    }
}
