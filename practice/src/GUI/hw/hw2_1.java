package GUI.hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class hw2_1 extends JFrame {
    JLabel label = new JLabel();
    MyFocusListener lis = new MyFocusListener();
    hw2_1() {
        setSize(300,300);

        JPanel panel = new JPanel();

        JTextField tf = new JTextField(5);
        tf.setText("0");
        tf.addFocusListener(lis);

        JTextField tf2 = new JTextField(5);
        tf2.setText("1");
        tf2.addFocusListener(lis);

        JTextField tf3 = new JTextField(5);
        tf3.setText("2");
        tf3.setFocusable(false);

        JTextField tf4 = new JTextField(5);
        tf4.setText("3");

        JTextField tf5 = new JTextField(5);
        tf5.setText("4");

        tf3.addFocusListener(lis);
        tf4.addFocusListener(lis);
        tf5.addFocusListener(lis);

        tf.requestFocus();

        panel.add(tf);
        panel.add(tf2);
        panel.add(tf3);
        panel.add(tf4);
        panel.add(tf5);

        add(panel, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
        setVisible(true);
    }

    class MyFocusListener extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent e) {
            JTextField field = (JTextField) e.getSource();
            label.setText(field.getText() + " has the Focus");
        }

        @Override
        public void focusLost(FocusEvent e) {
            super.focusLost(e);
        }
    }

    public static void main(String[] args) {
        new hw2_1();
    }
}
