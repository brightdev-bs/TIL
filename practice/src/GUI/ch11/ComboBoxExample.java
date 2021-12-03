package GUI.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxExample extends JFrame {

    ComboBoxExample() {
        setSize(300,300);
        JComboBox box = new JComboBox();
        JTextField tf = new JTextField(10);
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tf.getText();
                box.addItem(s);
                tf.setText("");
            }
        });
        setLayout(new FlowLayout());
        add(tf); add(box);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBoxExample();
    }
}
