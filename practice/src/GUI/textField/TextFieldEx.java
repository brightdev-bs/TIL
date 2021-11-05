package GUI.textField;

import javax.swing.*;
import java.awt.*;

public class TextFieldEx extends JFrame {

    TextFieldEx() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JTextField textField = new JTextField("연습", 5);
        add(textField);

        setSize(500,500);
        setVisible(true);

    }

    public static void main(String[] args) {
        new TextFieldEx();
    }
}
