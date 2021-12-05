package GUI.ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogExample2 extends JFrame {

    DialogExample2() {
        JButton btn = new JButton("show dialog");
        MyDialog dialog = new MyDialog(this, "test");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
        add(btn);
        setSize(250,300);
        setVisible(true);
    }

    class MyDialog extends JDialog {
        JTextField tf = new JTextField(10);
        JButton button = new JButton("OK");
        public MyDialog(JFrame frame, String title) {
            setLayout(new FlowLayout());
            add(tf);
            add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });
            setSize(300,300);
        }
    }

    public static void main(String[] args) {
        new DialogExample2();
    }
}
