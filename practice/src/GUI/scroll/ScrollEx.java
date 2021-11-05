package GUI.scroll;

import javax.swing.*;

public class ScrollEx extends JFrame {

    ScrollEx() {
        setTitle("ScrollPane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        JLabel view = new JLabel(new ImageIcon(getClass().getResource("apple.jpg")));
        JScrollPane sp = new JScrollPane(view);
        add(sp);
        sp.setBounds(20,20,120,120);
        setSize(250,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ScrollEx();
    }
}
