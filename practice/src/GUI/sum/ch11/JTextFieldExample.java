package GUI.sum.ch11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldExample extends JFrame {

    String[] pos = { "JTextField.LEFT", "JTextField.RIGHT", "JTextField.CENTER" };

    JTextFieldExample() {
        JTextField textField = new JTextField(10);
        textField.setText("enter키");
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setHorizontalAlignment(JTextField.RIGHT);
            }
        });

        add(textField);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTextFieldExample();
    }
}
