package GUI.ch14;

import javax.swing.*;
import java.awt.*;

public class JMenuBarExample extends JFrame {

    JMenuBarExample() {
        setSize(300,300);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Screen");
        JMenuItem item1 = new JMenuItem("Load");
        JMenuItem item2 = new JMenu("Hide");

        menu.add(item1); menu.add(item2);
        menu.addSeparator();
        menu.add(new JMenuItem("Thrid"));

        JMenu menu2 = new JMenu("Edit");

        menuBar.add(menu); menuBar.add(menu2);

        add(menuBar, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new JMenuBarExample();
    }
}
