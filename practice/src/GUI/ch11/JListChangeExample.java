package GUI.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class JListChangeExample extends JFrame  {

    Vector<String> list = new Vector<>();

    JListChangeExample() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3,1));
        add(new JLabel("이름 입력 후 enter"));

        list.add("김"); list.add("병");
        JList jl = new JList(list);
        JTextField tf = new JTextField(10);
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField tmp = (JTextField) e.getSource();
                String s = tmp.getText();
                list.add(s);
                jl.setListData(list);
                tmp.setText("");
            }
        });

        add(tf); add(jl);

        setVisible(true);

    }

    public static void main(String[] args) {
        new JListChangeExample();
    }
}
