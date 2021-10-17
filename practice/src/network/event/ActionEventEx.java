package network.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx extends JFrame {
    JLabel label;

    ActionEventEx() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("No Label", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout());

        JButton button = new JButton("Summer");
        button.addActionListener(e -> {
           label.setText("Summer");
        });
        JButton button2 = new JButton("Winter");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Winter");
            }
        });
        JButton button3 = new JButton("Exit");

        panel.add(button);
        panel.add(button2);
        panel.add(button3);

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ActionEventEx();
    }
}
