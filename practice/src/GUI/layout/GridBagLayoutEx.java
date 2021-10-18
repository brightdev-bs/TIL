package GUI.layout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutEx extends JFrame {

    GridBagLayoutEx() {
        setSize(300,300);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton btn1 = new JButton("North");
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(btn1, constraints);
        JButton btn2 = new JButton("South");
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(btn2, constraints);
        JButton btn3 = new JButton("East");
        constraints.gridx = 2;
        constraints.gridy = 1;
        add(btn3, constraints);
        JButton btn4 = new JButton("West");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(btn4, constraints);
        JButton btn5 = new JButton("Center");
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(btn5, constraints);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutEx();
    }
}
