package GUI.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutEx2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("문제2");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(new JButton("Add"));
        frame.add(new JButton("Delete"));

        frame.setVisible(true);
    }
}
