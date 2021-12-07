package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;

public class OpaqueExample extends JFrame {

    OpaqueExample() {
        getContentPane().setBackground(Color.gray);
        JPanel inner = new JPanel();
        inner.setBorder(BorderFactory.createTitledBorder("panel"));
        inner.setPreferredSize(new Dimension(200,200));
        inner.setOpaque(true);
        inner.setBackground(Color.green);

        JButton btn = new JButton("Hello");
        btn.setBackground(Color.YELLOW);

        inner.add(btn);
        add(inner);

        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);

    }

    public static void main(String[] args) {
        new OpaqueExample();
    }
}
