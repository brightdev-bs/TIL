package GUI.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawLinePanel extends JFrame {
    JPanel panel;
    JButton button;

    DrawLinePanel() {
        setLayout(new GridLayout(2,1));

        button = new JButton("Add Line");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText() == "Add Line") {
                    btn.setText("Clear Line");
                }
            }
        });

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

            }
        };

        add(panel);
        add(button);
    }

    public static void main(String[] args) {

    }
}
