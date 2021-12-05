package GUI.ch14;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuEventExample2 extends JFrame {

    JLabel menuLabel = new JLabel("This is label1");
    JLabel actionLabel = new JLabel("This is label2");

    JMenuEventExample2() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        JMenuItem item = new JMenuItem("label");
        JMenuItem item2 = new JMenuItem("Open");

        menu.add(item); menu.add(item2);

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                actionLabel.setText(s);
                System.out.println("actionListener");
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                actionLabel.setText(s);
                System.out.println("actionListener");
            }
        });


        menu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                menuLabel.setText("menuSelected");
                System.out.println("selected");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                menuLabel.setText("menuDeselected");
                System.out.println("deselected");
            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        setLayout(new GridLayout(3,1));

        menuBar.add(menu);
        add(menuBar);
        add(menuLabel); add(actionLabel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new JMenuEventExample2();
    }
}
