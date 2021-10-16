package GUI.layout;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {

    GridLayoutEx() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JButton button = new JButton("North");
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(button, constraints);

        JButton button2 = new JButton("South");
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(button2, constraints);

        JButton button3 = new JButton("West");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(button3, constraints);

        JButton button4 = new JButton("East");
        constraints.gridx = 2;
        constraints.gridy = 1;
        panel.add(button4, constraints);

        JButton button5 = new JButton("Center");
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(button5, constraints);

        add(panel);
        setSize(500,500);
        setVisible(true);


    }

    public static void main(String[] args) {
        new GridLayoutEx();
    }
}
