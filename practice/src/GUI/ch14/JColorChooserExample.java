package GUI.ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JColorChooserExample extends JFrame {

    JLabel text = new JLabel("Hello");

    JColorChooserExample() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu();
        JMenuItem menuItem = new JMenuItem("Color");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorChooser = new JColorChooser();
                Color selectedColor = colorChooser.showDialog(null, "Color", Color.blue);
                if(selectedColor != null) {
                    text.setForeground(selectedColor);
                }
            }
        });



        menu.add(menuItem);
        menuBar.add(menu);

        add(menuBar, BorderLayout.NORTH);
        add(text, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new JColorChooserExample();
    }
}
