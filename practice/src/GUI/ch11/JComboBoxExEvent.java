package GUI.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxExEvent extends JFrame {
    String[] flowers = { "flower1", "flower2"};
    ImageIcon[] images = {
            new ImageIcon(getClass().getResource("flower.jpeg")),
            new ImageIcon(getClass().getResource("flower2.jpeg"))
    };

    JComboBoxExEvent() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        JLabel imgLabel = new JLabel(images[0]);
        JComboBox comboBox = new JComboBox(flowers);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox tmp = (JComboBox) e.getSource();
                int idx = tmp.getSelectedIndex();
                imgLabel.setIcon(images[idx]);
            }
        });

        add(comboBox);
        add(imgLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new JComboBoxExEvent();
    }
}