package GUI.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ch10_1 extends JFrame {

    Ch10_1() {
        setSize(300,300);
        JButton button = new JButton("Action");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("Action"))
                    button.setText("액션");
                else
                    button.setText("Action");
            }
        });
        add(button, BorderLayout.CENTER);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Ch10_1();
    }
}
