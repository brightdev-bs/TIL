package GUI.ch14;

import javax.swing.*;

public class JTabbedPaenExample extends JFrame {

    JTabbedPaenExample() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("tab1", new JLabel(new ImageIcon(getClass().getResource("tool.png"))));
        tabbedPane.addTab("tab2", new JLabel(new ImageIcon(getClass().getResource("flower.jpg"))));
        add(tabbedPane);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTabbedPaenExample();
    }
}
