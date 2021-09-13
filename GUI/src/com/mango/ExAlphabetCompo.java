package com.mango;

import javax.swing.*;
import java.awt.*;

public class ExAlphabetCompo extends JFrame {

    public ExAlphabetCompo() {
        setTitle("컴포넌트-알파벳");
        getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setLayout(new FlowLayout(FlowLayout.TRAILING));
        for(int i = 0; i < 26; i++) {
            Character c = (char) (i + 'A');
            JButton jButton = new JButton(c.toString());
            add(jButton);
        }
        setVisible(true);
        setSize(350, 150);
    }

    public static void main(String[] args) {
        ExAlphabetCompo ex = new ExAlphabetCompo();
    }
}
