package GUI.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaExample extends JFrame {
    String input;
    JTextArea ta;

    JTextAreaExample() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 1));

        add(new JLabel("입력 후 enter키를 입력하세요"));
        ta = new JTextArea(5,10);
        JTextField tf = new JTextField(10);
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField tf = (JTextField) e.getSource();
                input = tf.getText();
                ta.append(input + "\n");
                tf.setText("");
            }
        });

        add(tf);
        add(ta);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTextAreaExample();
    }
}
