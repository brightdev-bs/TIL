package GUI.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JComboBoxExample extends JFrame {

    JComboBoxExample() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] furits = { "apple", " bannana", "mango" , "kiwi"};
        JComboBox ck = new JComboBox(furits);

        JButton btn = new JButton("클릭");
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int idx = ck.getItemCount()-1;
                System.out.println(ck.getItemAt(idx));
            }
        });

        add(btn);

        String[] names = {"kim", "park"};
        JComboBox ck2 = new JComboBox();
        for(String s : names) {
            ck2.addItem(s);
        }

        setLayout(new GridLayout(2,1));
        add(ck); add(ck2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new JComboBoxExample();
    }
}
