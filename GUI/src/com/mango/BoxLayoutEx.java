package com.mango;

import javax.swing.*;

public class BoxLayoutEx extends JFrame {

    BoxLayoutEx() {
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeUI();
        setVisible(true);
    }

    public void makeUI() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(new JButton("Add"));
        add(Box.createHorizontalStrut(10));
        add(new JButton("Delete"));
        add(Box.createHorizontalStrut(10));
        add(new JButton("Modify"));
        add(Box.createHorizontalStrut(10));
        add(new JButton("Exit"));
        add(Box.createHorizontalStrut(10));
    }

    public static void main(String[] args) {
        new BoxLayoutEx();
    }
}
