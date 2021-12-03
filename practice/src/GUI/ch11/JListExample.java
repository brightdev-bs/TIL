package GUI.ch11;

import javax.swing.*;

public class JListExample extends JFrame {

    JListExample() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] fruits = {"apple", "pear", "kiwi", "mango"};
        JList<String> strList = new JList(fruits);

        add(strList);

        setVisible(true);
    }

    public static void main(String[] args) {
        new JListExample();
    }
}
