package GUI.ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPaneExample4 extends JFrame{
    JTextField textField = new JTextField(10);

    OptionPaneExample4() {
        JButton inputBtn = new JButton("input Name");
        inputBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("이름을 입력하세요");
                textField.setText(s);
            }
        });
        JButton confirmBtn = new JButton("Confirm");
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "계속?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.CLOSED_OPTION) {
                    textField.setText("x버튼");
                } else if(result == JOptionPane.YES_OPTION) {
                    textField.setText("yes");
                } else {
                    textField.setText("no");
                }
            }
        });

        JButton message = new JButton("Message");
        message.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "조심하세요", "Message", JOptionPane.YES_OPTION);
            }
        });

        setLayout(new FlowLayout());

        add(inputBtn);
        add(confirmBtn);
        add(message);
        add(textField);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new OptionPaneExample4();
    }
}
