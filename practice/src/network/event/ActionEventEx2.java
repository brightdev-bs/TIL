package network.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx2 extends JFrame {

    ActionEventEx2() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4,2));

        add(new JLabel("한 변의 길이를 입력하시오"));
        JTextField textField = new JTextField(10);
        add(textField);
        add(new JLabel("면적"));
        JTextField textField2 = new JTextField(10);
        add(textField2);
        add(new JLabel("둘레"));
        JTextField textField3 = new JTextField(10);
        add(textField3);

        JButton button = new JButton("계산");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(textField.getText());
                textField3.setText(String.valueOf(4 * n));
                textField2.setText(String.valueOf(n * n));
            }
        });
        add(button);
        JButton button2 = new JButton("Exit");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(button2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ActionEventEx2();
    }
}
