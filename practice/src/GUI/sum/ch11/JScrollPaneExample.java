package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;

public class JScrollPaneExample extends JFrame {

    JScrollPaneExample() {
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("pear.jpeg")));
        JScrollPane scrollPane = new JScrollPane(label, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        setLayout(new FlowLayout());
        add(scrollPane);

        setVisible(true);
        setSize(300,300);
    }

    public static void main(String[] args) {
        new JScrollPaneExample();
    }
}
