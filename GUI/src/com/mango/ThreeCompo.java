package com.mango;

import javax.swing.*;
import java.awt.*;

class MyThreeCompo extends JFrame {
    MyThreeCompo() {
        setTitle("컴포 3개");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame을 닫았을 때 끝내라

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JButton("ok"));
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Igonore"));

        setSize(350, 150);
        setVisible(true);
    }
}

public class ThreeCompo {


    public static void main(String[] args) {
        MyThreeCompo cp = new MyThreeCompo();
    }
}
