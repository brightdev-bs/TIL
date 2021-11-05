package GUI.textField;

import javax.swing.*;
import java.awt.*;

public class TextFieldEx2 extends JFrame {

    TextFieldEx2() {
        setSize(300,300);
        setLayout(new FlowLayout());

        add(new JLabel("이름 : "));
        JTextField textField = new JTextField(10);
        textField.setEditable(false);
        textField.setMargin(new Insets(10,10,10,10));
        add(textField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TextFieldEx2();
    }
}
