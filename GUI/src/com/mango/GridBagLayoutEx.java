package com.mango;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutEx extends JFrame {
    GridBagConstraints glc = new GridBagConstraints();
    GridBagLayout gbl = new GridBagLayout();
    JPanel panel;

    public GridBagLayoutEx() {
        panel = new JPanel();
        panel.setLayout(gbl);
        panel.setBorder(BorderFactory.createTitledBorder("Grid Coordinates"));
        int x, y;
        addComponent(new JButton("North"), x = 1, y = 0);
        addComponent(new JButton("West"), x = 0, y = 1);
        addComponent(new JButton("Center"), x = 1, y = 1);
        addComponent(new JButton("East"), x = 2, y = 1);
        addComponent(new JButton("South"), x = 1, y = 2);
        setContentPane(panel);
        setSize(300, 300);
        setVisible(true);
    }

    public void addComponent(Component compo, int x, int y) {
        glc.gridx = x;
        glc.gridy = y;
        panel.add(compo, glc);
    }

    public static void main(String[] args) {
        new GridBagLayoutEx();
    }
}
