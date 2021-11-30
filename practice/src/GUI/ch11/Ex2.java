package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class Ex2 extends JFrame {

    Ex2() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.gray);
        setLayout(new FlowLayout());
        JPanel outPanel = new JPanel();
        outPanel.setBackground(Color.GREEN);
        //outPanel.setOpaque(false);

        JPanel inPanel = new JPanel();
        inPanel.setBackground(Color.YELLOW);
        //inPanel.setOpaque(true);

        JButton btn = new JButton();
        btn.setBackground(Color.white);
        inPanel.add(btn);


        outPanel.add(inPanel);

        add(outPanel);


        setVisible(true);
    }



    public static void main(String[] args) {
        new Ex2();
    }
}
