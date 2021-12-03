package GUI.ch11;

import javax.swing.*;

public class JListScroll extends JFrame {

    JListScroll() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon[] icons = {
                new ImageIcon(getClass().getResource("flower.jpeg")),
                new ImageIcon(getClass().getResource("flower2.jpeg")),
                new ImageIcon(getClass().getResource("flower3.jpeg"))
        };
        JList list = new JList(icons);
        JScrollPane js = new JScrollPane(list);

        add(js);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JListScroll();
    }
}
